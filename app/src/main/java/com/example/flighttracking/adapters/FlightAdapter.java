package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.flighttracking.R;
import com.example.flighttracking.models.flights.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.StatusViewHolder>{

    private Context mContext;
    private Response responses;

    public FlightAdapter(Context mContext, Response responses) {
        this.mContext = mContext;
        this.responses = responses;
    }

    @NonNull
    @Override
    public FlightAdapter.StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaystatus, parent, false);
        FlightAdapter.StatusViewHolder statusViewHolder = new FlightAdapter.StatusViewHolder(view);
        return statusViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlightAdapter.StatusViewHolder holder, int position) {
        holder.bindStatus(responses);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.regNo) TextView mReg;
        @BindView(R.id.manufact) TextView mManufat;
        @BindView(R.id.flightNo) TextView mFlight;
        @BindView(R.id.depart) TextView mDepart;
        @BindView(R.id.arrivaltime) TextView mArrive;

        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindStatus(Response response){
            mReg.setText(response.getRegNumber());
            mManufat.setText(response.getManufacturer());
            mFlight.setText(response.getFlightNumber());
            mDepart.setText(response.getDepTime());
            mArrive.setText(response.getArrTime());

        }
    }
}
