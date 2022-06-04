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
import com.example.flighttracking.fragments.FlightsFragment;
import com.example.flighttracking.models.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCountryAdapter extends RecyclerView.Adapter<MyCountryAdapter.DisplayViewHolder> {

    private Context mContext;
    private List<Response> responses;

    public MyCountryAdapter(Context mContext, List<Response> responses) {
        this.mContext = mContext;
        this.responses = responses;
    }

    @NonNull
    @Override
    public MyCountryAdapter.DisplayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaycountry, parent, false);
        DisplayViewHolder displayViewHolder = new DisplayViewHolder(view);
        return displayViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCountryAdapter.DisplayViewHolder holder, int position) {
        holder.bindCountry(responses.get(position));
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public void setResultList(List<Response> responses) {
        this.responses=responses;
        notifyDataSetChanged();
    }

    public class DisplayViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mycard) CardView mCard;
        @BindView(R.id.countryview) TextView mCountry;
        @BindView(R.id.codeView) TextView mCode;


        public DisplayViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindCountry(Response response){
            mCountry.setText(response.getName());
            mCode.setText(response.getCode());

        }
    }
}
