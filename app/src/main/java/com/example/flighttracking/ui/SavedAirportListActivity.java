package com.example.flighttracking.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FirebaseAirportViewHolder;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedAirportListActivity extends AppCompatActivity {

    private DatabaseReference mAirportReference;
    private FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder> mFirebaseAdapter;

    @BindView(R.id.search_results) RecyclerView searchResults;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_airport);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mAirportReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_AIRPORTS)
                .child(uid);

        setUpFirebaseAdapter();
        hideProgressBar();
        showRestaurants();
    }
    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<AirportsByCountry> options = new FirebaseRecyclerOptions.Builder<AirportsByCountry>()
                        .setQuery(mAirportReference, AirportsByCountry.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseAirportViewHolder firebaseAirportViewHolder, int position, @NonNull AirportsByCountry airport) {
                firebaseAirportViewHolder.bindSpecific(airport);
            }
            @NonNull
            @Override
            public FirebaseAirportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specific, parent, false);
                return new FirebaseAirportViewHolder(view);
            }
        };
        searchResults.setLayoutManager(new LinearLayoutManager(this));
        searchResults.setAdapter(mFirebaseAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
    private void showRestaurants() {
       searchResults.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}