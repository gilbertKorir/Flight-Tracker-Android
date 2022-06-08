package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.R;
//import com.example.flighttracking.models.country.Response;
import com.example.flighttracking.models.portsbycountry.Airport;
import com.example.flighttracking.models.portsbycountry.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecificRecyclerAdapter extends RecyclerView.Adapter<SpecificRecyclerAdapter.MyHolder>{

    private Context context;
    private List<Airport> airports;

    public SpecificRecyclerAdapter(Context context, List<Airport> airports) {
        this.context = context;
        this.airports = airports;
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
        holder.bindSpecific(airports.get(position));
    }

    @Override
    public int getItemCount() {
         return airports.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameView) TextView name;
        @BindView(R.id.popularity) TextView popularity;
        @BindView(R.id.cityCode) TextView city;
        @BindView(R.id.countryCode) TextView country;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context = itemView.getContext();
        }
        public void bindSpecific(Airport airport){
            name.setText(airport.getName());
            popularity.setText(airport.getPopularity());
            city.setText(airport.getCityCode());
            country.setText(airport.getCountryCode());
        }
    }
}
