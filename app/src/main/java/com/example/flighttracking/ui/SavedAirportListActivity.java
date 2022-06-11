package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FirebaseAirportViewHolder;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;

public class SavedAirportListActivity extends AppCompatActivity {
    private DatabaseReference mRestaurantReference;
    private FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder> mFirebaseAdapter;

    @BindView(R.id.search_results) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);
    }
}