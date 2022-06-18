package com.example.flighttracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
//import com.example.flighttracking.models.country.Response;
import com.example.flighttracking.fragments.AirportDetailFragment;
import com.example.flighttracking.models.portsbycountry.Airport;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.models.portsbycountry.Response;
import com.example.flighttracking.ui.AirportsDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecificRecyclerAdapter extends RecyclerView.Adapter<SpecificRecyclerAdapter.MyHolder>{

    private Context context;
    private ArrayList<AirportsByCountry> mairports = new ArrayList<>();

    public SpecificRecyclerAdapter(Context context, ArrayList<AirportsByCountry> airports) {
        this.context = context;
        this.mairports = airports;
    }

    @NonNull
    @Override
    public SpecificRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.specific,parent,false);
        return  new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SpecificRecyclerAdapter.MyHolder holder, int position) {
        holder.bindSpecific(mairports.get(position));
    }

    @Override
    public int getItemCount() {
         return mairports.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.nameView) TextView name;
        @BindView(R.id.popularity) TextView popularity;
        @BindView(R.id.cityCode) TextView city;
        @BindView(R.id.countryCode) TextView country;
        private Context mContext;
        private int mOrientation;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            // Determines the current orientation of the device:
            mOrientation = itemView.getResources().getConfiguration().orientation;

            // Checks if the recorded orientation matches Android's landscape configuration.
            // if so, we create a new DetailFragment to display in our special landscape layout:
            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                createDetailFragment(0);
            }
        }
        public void bindSpecific(AirportsByCountry airport){
            name.setText(airport.getName());
            popularity.setText("Popularity: " + airport.getPopularity().toString());
            city.setText("City code: " + airport.getCityCode());
            country.setText("Country code: " + airport.getCountryCode());
        }
        @Override
        public void onClick(View v) {
            //clicking individual airport
            int itemPosition = getLayoutPosition();
            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                createDetailFragment(itemPosition);
            } else {
                Intent intent = new Intent(context, AirportsDetailActivity.class);
                intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                intent.putExtra(Constants.EXTRA_KEY_AIRPORTS, Parcels.wrap(mairports));
                context.startActivity(intent);
            }
//            Intent intent = new Intent(context, AirportsDetailActivity.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("airports", Parcels.wrap(mairports));
//            context.startActivity(intent);
        }
        // Takes position of restaurant in list as parameter:
        private void createDetailFragment(int position) {
            // Creates new RestaurantDetailFragment with the given position:
            AirportDetailFragment detailFragment = AirportDetailFragment.newInstance(mairports, position);
            // Gathers necessary components to replace the FrameLayout in the layout with the RestaurantDetailFragment:
            FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
            //  Replaces the FrameLayout with the RestaurantDetailFragment:
            ft.replace(R.id.airportDetailContainer, detailFragment);
            // Commits these changes:
            ft.commit();
        }
    }
}
