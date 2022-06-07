package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;

import com.example.flighttracking.adapters.SpecificRecyclerAdapter;

import com.example.flighttracking.models.portsbycountry.Airport;
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
//    Response response;
    @BindView(R.id.search_results) RecyclerView searchResults;

//    private List<Airport> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        AirApi client = AirClient.getClient();
        Call<Response> call = client.getSpecific(country, Constants.AIR_API_KEY);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response){
                if(response.isSuccessful()){

                    List<Airport> mList  = response.body().getAirports();
                   SpecificRecyclerAdapter myCountryAdapter = new SpecificRecyclerAdapter(getApplicationContext(), mList);
                    searchResults.setAdapter(myCountryAdapter);
//                   myCountryAdapter.setResultList(mList);
                    searchResults.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}