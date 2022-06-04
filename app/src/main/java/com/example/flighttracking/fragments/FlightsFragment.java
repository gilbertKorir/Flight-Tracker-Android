package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.MyCountryAdapter;
import com.example.flighttracking.models.CountrySearchResponse;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;
import com.example.flighttracking.ui.AllActivity;
//import com.example.flighttracking.ui.FlightsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlightsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlightsFragment extends Fragment {

    private MyCountryAdapter mDisplayAdapter;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flights, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        AirApi client = AirClient.getClient();
        Call<CountrySearchResponse> call = client.getCountry(Constants.AIR_API_KEY);

        call.enqueue(new Callback<CountrySearchResponse>() {

            @Override
            public void onResponse(Call<CountrySearchResponse> call, Response<CountrySearchResponse> response) {

                List<com.example.flighttracking.models.Response> mList = response.body().getResponse();

                MyCountryAdapter myCountryAdapter = new MyCountryAdapter(mRecyclerView.getContext(), mList);
                mRecyclerView.setAdapter(myCountryAdapter);
//                   myCountryAdapter.setResultList(mList);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void onFailure(Call<CountrySearchResponse> call, Throwable t) {

            }
        });
    }
}