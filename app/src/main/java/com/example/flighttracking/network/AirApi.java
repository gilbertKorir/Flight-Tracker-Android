package com.example.flighttracking.network;

import com.example.flighttracking.models.CountrySearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirApi {
        @GET("countries")
        Call<CountrySearchResponse> getCountry(@Query("api_key") String api_key);
}
