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
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    private static final String TAG = SpecificAirportActivity.class.getSimpleName();
    @BindView(R.id.search_results) RecyclerView searchResults;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
//    public  List<Airport> airports;

    //shared prefernce
//    private SharedPreferences mSharedPreferences;
//    private String mRecentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        //retrieving location from shared preference
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        String country = intent.getStringExtra("country");

        AirApi client = AirClient.getClient();
        Call<AirportsSearch> call = client.getSpecific(country, Constants.AIR_API_KEY);

        call.enqueue(new Callback<AirportsSearch>() {
            @Override
            public void onResponse(Call<AirportsSearch> call, retrofit2.Response<AirportsSearch> response){
                hideProgressBar();
                if(response.isSuccessful()){
                    List<AirportsByCountry> airports = response.body().getResponse().getAirportsByCountries();

                   SpecificRecyclerAdapter specificRecyclerAdapter = new SpecificRecyclerAdapter(SpecificAirportActivity.this, airports);
                    searchResults.setAdapter(specificRecyclerAdapter);
//                   myCountryAdapter.setResultList(mList);
                    searchResults.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    searchResults.setHasFixedSize(true);
                }
                else{
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<AirportsSearch> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
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

//        private void showRestaurants() {
//            mRecyclerView.setVisibility(View.VISIBLE);
//        }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}