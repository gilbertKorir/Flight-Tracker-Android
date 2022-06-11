package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;

import com.example.flighttracking.adapters.SpecificRecyclerAdapter;

import com.example.flighttracking.models.portsbycountry.Airport;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.models.portsbycountry.AirportsSearch;
import com.example.flighttracking.models.portsbycountry.Response;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class SpecificAirportActivity extends AppCompatActivity {

    @BindView(R.id.search_results) RecyclerView searchResults;
//    public  List<Airport> airports;

    //shared prefernce
    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);
        ButterKnife.bind(this);

        Intent intent = getIntent();
//        String country = intent.getStringExtra("country");

        //retrieving location from shared preference
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        String country = intent.getStringExtra("country");

        AirApi client = AirClient.getClient();
        Call<AirportsSearch> call = client.getSpecific(country, Constants.AIR_API_KEY);

        call.enqueue(new Callback<AirportsSearch>() {
            @Override
            public void onResponse(Call<AirportsSearch> call, retrofit2.Response<AirportsSearch> response){
                if(response.isSuccessful()){

                    List<AirportsByCountry> airports = response.body().getResponse().getAirportsByCountries();
                   SpecificRecyclerAdapter specificRecyclerAdapter = new SpecificRecyclerAdapter(SpecificAirportActivity.this, airports);
                    searchResults.setAdapter(specificRecyclerAdapter);
//                   myCountryAdapter.setResultList(mList);
                    searchResults.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    searchResults.setHasFixedSize(true);
                }
            }
            @Override
            public void onFailure(Call<AirportsSearch> call, Throwable t) {

            }
        });
    }
}