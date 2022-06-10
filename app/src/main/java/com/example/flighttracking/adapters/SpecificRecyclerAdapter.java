package com.example.flighttracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.R;
//import com.example.flighttracking.models.country.Response;
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
    private List<AirportsByCountry> mairports;

    public SpecificRecyclerAdapter(Context context, List<AirportsByCountry> airports) {
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

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        public void bindSpecific(AirportsByCountry airport){
            name.setText(airport.getName());
            popularity.setText(airport.getPopularity().toString());
            city.setText(airport.getCityCode());
            country.setText(airport.getCountryCode());
        }

        @Override
        public void onClick(View v) {
            //clicking individual airport
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(context, AirportsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("airports", Parcels.wrap(mairports));
            context.startActivity(intent);
        }
    }
}
