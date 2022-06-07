package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.models.portsbycountry.Airport;

import java.util.List;

public class SpecificRecyclerAdapter extends RecyclerView.Adapter<SpecificRecyclerAdapter.MyHolder>{

    private Context context;
    private List<Airport> list;

    public SpecificRecyclerAdapter(Context context, List<Airport> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SpecificRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificRecyclerAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
