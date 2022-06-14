package com.example.flighttracking.network;

import com.example.flighttracking.models.airports.AirportsListResponse;
import com.example.flighttracking.models.country.CountrySearchResponse;
import com.example.flighttracking.models.flights.ConfirmFlight;
import com.example.flighttracking.models.portsbycountry.AirportsSearch;
import com.example.flighttracking.models.portsbycountry.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirApi {
        @GET("countries")
        Call<CountrySearchResponse> getCountry(@Query("api_key") String api_key);
        @GET("airports")
        Call<AirportsListResponse> getAirport(@Query("api_key") String api_key);
        @GET("suggest")
        Call<AirportsSearch> getSpecific(@Query("q") String country,
                                         @Query("api_key") String api_key);
        @GET("flight")
        Call<ConfirmFlight> getFlight(@Query("flight_iata") String flight_iata,
                                        @Query("api_key") String api_key);
}
