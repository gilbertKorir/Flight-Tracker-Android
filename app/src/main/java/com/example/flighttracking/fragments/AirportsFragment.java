package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.MyAirportAdapter;
import com.example.flighttracking.adapters.MyCountryAdapter;
import com.example.flighttracking.models.airports.AirportsListResponse;
import com.example.flighttracking.models.country.CountrySearchResponse;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AirportsFragment extends Fragment {

    private MyAirportAdapter mDisplayAdapter;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;

    public AirportsFragment() {
        // Required empty public constructor
    }

    public static AirportsFragment newInstance(String param1, String param2) {
        AirportsFragment fragment = new AirportsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        AirApi client = AirClient.getClient();
        Call<AirportsListResponse> call = client.getAirport(Constants.AIR_API_KEY);

        call.enqueue(new Callback<AirportsListResponse>() {
            @Override
            public void onResponse(Call<AirportsListResponse> call, Response<AirportsListResponse> response) {
                if(response.isSuccessful()){

                    List<com.example.flighttracking.models.airports.Response> mResponse = response.body().getResponse();
                    MyAirportAdapter myAirportAdapter = new MyAirportAdapter(mRecyclerView.getContext(),mResponse);
                    mRecyclerView.setAdapter(myAirportAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                }
                else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<AirportsListResponse> call, Throwable t) {
                showFailureMessage();
            }
        });

    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
}