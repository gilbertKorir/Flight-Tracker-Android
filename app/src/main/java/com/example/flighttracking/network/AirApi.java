package com.example.flighttracking.network;

import com.example.flighttracking.models.airports.AirportsListResponse;
import com.example.flighttracking.models.country.CountrySearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirApi {
        @GET("countries")
        Call<CountrySearchResponse> getCountry(@Query("api_key") String api_key);
        @GET("airports")
        Call<AirportsListResponse> getAirport(@Query("api_key") String api_key);
}
