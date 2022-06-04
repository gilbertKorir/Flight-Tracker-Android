package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flighttracking.R;
import com.example.flighttracking.models.airports.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displayairport, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindCountry(responses.get(position));
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.airportView) TextView mAirport;
        @BindView(R.id.iata) TextView mIata;
        @BindView(R.id.icaocode) TextView mIcao;
        @BindView(R.id.latitude) TextView mLat;
        @BindView(R.id.longitude) TextView mLong;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindCountry(Response response){
            mAirport.setText(response.getName());
            mIata.setText(response.getIataCode());
            mIcao.setText(response.getIcaoCode());
            mLat.setText(response.getLat().toString());
            mLong.setText(response.getLng().toString());

        }
    }
}
