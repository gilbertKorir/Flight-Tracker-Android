package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.R;
import com.example.flighttracking.models.airports.Response;

import java.util.List;

public class MyAirportAdapter extends RecyclerView.Adapter<MyAirportAdapter.MyViewHolder> {

    private Context mContext;
    private List<Response> responses;

    public MyAirportAdapter(Context mContext, List<Response> responses) {
        this.mContext = mContext;
        this.responses = responses;
    }

    @NonNull
    @Override
    public MyAirportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaycountry, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
