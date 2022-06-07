package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flighttracking.R;
import com.example.flighttracking.adapters.SpecificRecyclerAdapter;
import com.example.flighttracking.models.portsbycountry.Response;

import butterknife.BindView;

public class SpecificAirportActivity extends AppCompatActivity {
    Response response;
    @BindView(R.id.search_results) RecyclerView searchResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);

        response = (Response) getIntent().getSerializableExtra("Response");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        searchResults.setLayoutManager(gridLayoutManager);
        searchResults.setAdapter(new SpecificRecyclerAdapter(this,response.getAirports()));
    }
}