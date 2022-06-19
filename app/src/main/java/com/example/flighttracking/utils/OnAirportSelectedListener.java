package com.example.flighttracking.utils;

import com.example.flighttracking.models.portsbycountry.AirportsByCountry;

import java.util.ArrayList;

public interface OnAirportSelectedListener {
    public void onAiportSelected(Integer position, ArrayList<AirportsByCountry> airports, String source);
}
