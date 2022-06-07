package com.example.flighttracking.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.Response;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;
import com.example.flighttracking.ui.SpecificAirportActivity;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
//import com.example.flighttracking.ui.FormActivity;

public class FlightsFragment extends Fragment {

    @BindView(R.id.searc_view) SearchView searchView;
    @BindView(R.id.searchButton) Button search;
    AirApi airApi;

    public FlightsFragment() {
        // Required empty public constructor
    }

    public static FlightsFragment newInstance(String param1, String param2) {
        FlightsFragment fragment = new FlightsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flights, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        airApi = AirClient.getClient();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Response> call = airApi.searchGif(searchView.getQuery().toString(), Constants.AIR_API_KEY);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Intent intent = new Intent(getContext(), SpecificAirportActivity.class);
                        intent.putExtra("Response",response.body().toString());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

            }
        });
    }
    }