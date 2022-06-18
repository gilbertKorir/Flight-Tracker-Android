package com.example.flighttracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.ui.AirportsDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseAirportViewHolder extends RecyclerView.ViewHolder  {

    View mView;
    Context mContext;
    public TextView mNameview;

    public FirebaseAirportViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
    }
    public void bindSpecific(AirportsByCountry airport){
        mNameview = (TextView) mView.findViewById(R.id.nameView);
        TextView popularityTextView = (TextView) mView.findViewById(R.id.popularity);
        TextView cityTextView = (TextView) mView.findViewById(R.id.cityCode);
        TextView countryTextView = (TextView) mView.findViewById(R.id.countryCode);

        mNameview.setText(airport.getName());
        popularityTextView.setText("Popularity: " + airport.getPopularity().toString());
        cityTextView.setText("City code: " + airport.getCityCode());
        countryTextView.setText("Country code: " + airport.getCountryCode());
    }

//    @Override
//    public void onClick(View v) {
//        final ArrayList<AirportsByCountry> airports = new ArrayList<>();
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
////        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS).child(uid);
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_AIRPORTS).child(uid);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    airports.add(snapshot.getValue(AirportsByCountry.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//                Intent intent = new Intent(mContext, AirportsDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("airports", Parcels.wrap(airports));
//
//                mContext.startActivity(intent);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

}
