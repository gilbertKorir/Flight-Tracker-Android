package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flighttracking.R;

public class AirportsFragment extends Fragment {



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
}