package com.example.flighttracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.ui.AirportsDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseAirportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseAirportViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindSpecific(AirportsByCountry airport){
        TextView nameTextView = (TextView) mView.findViewById(R.id.nameView);
        TextView popularityTextView = (TextView) mView.findViewById(R.id.popularity);
        TextView cityTextView = (TextView) mView.findViewById(R.id.cityCode);
        TextView countryTextView = (TextView) mView.findViewById(R.id.countryCode);

        nameTextView.setText(airport.getName());
        popularityTextView.setText(airport.getPopularity().toString());
        cityTextView.setText(airport.getCityCode());
        countryTextView.setText(airport.getCountryCode());
    }

    @Override
    public void onClick(View v) {
        final ArrayList<AirportsByCountry> airports = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_AIRPORTS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    airports.add(snapshot.getValue(AirportsByCountry.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, AirportsDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("airports", Parcels.wrap(airports));

                mContext.startActivity(intent);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}