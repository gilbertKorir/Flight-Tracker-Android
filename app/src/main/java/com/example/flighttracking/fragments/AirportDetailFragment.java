package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;

import butterknife.ButterKnife;

public class AirportDetailFragment extends Fragment {

    private AirportsByCountry mAirport;

    public AirportDetailFragment() {
        // Required empty public constructor
    }

    public static AirportDetailFragment newInstance(AirportsByCountry airport) {
        AirportDetailFragment airportDetailFragment = new AirportDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("airport", Parcels.wrap(airport));
        airportDetailFragment.setArguments(args);
        return airportDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAirport = Parcels.unwrap(getArguments().getParcelable("airport"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_airport_detail, container, false);
        ButterKnife.bind(this, view);
        return view;

    }
}