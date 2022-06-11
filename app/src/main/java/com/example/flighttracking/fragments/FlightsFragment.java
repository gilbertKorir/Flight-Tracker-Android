package com.example.flighttracking.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.Response;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;
import com.example.flighttracking.ui.AllActivity;
import com.example.flighttracking.ui.MainActivity;
import com.example.flighttracking.ui.SpecificAirportActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
//import com.example.flighttracking.ui.FormActivity;

public class FlightsFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.editCountry) EditText msearch;
    @BindView(R.id.searchButton) Button search;
    AirApi airApi;
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
//      private String mRecentCountry;

    //Firebase
    private DatabaseReference mSearchedLocationReference;
    private ValueEventListener mSearchedLocationReferenceListener;

    public FlightsFragment() {
        // Required empty public constructor
    }

    public static FlightsFragment newInstance(String param1, String param2) {
        FlightsFragment fragment = new FlightsFragment();

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flights, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
//
////        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
////        mEditor = mSharedPreferences.edit();
        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);
        mSearchedLocationReferenceListener = mSearchedLocationReference.addValueEventListener(new ValueEventListener() { //attach listener

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                    String location = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + location); //log
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

            }
        });
//
        search.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                if (v == search) {
                    String country = msearch.getText().toString();
                    saveLocationToFirebase(country);

//                    if(!(country).equals("")) {
////                        addToSharedPreferences(country);
//                        saveLocationToFirebase(country);
//                    }
                    Intent intent = new Intent(getActivity(), SpecificAirportActivity.class);
                    intent.putExtra("country",country);
                    startActivity(intent);
                }
    }
    public void saveLocationToFirebase(String country) {
        mSearchedLocationReference.push().setValue(country);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }

//    private void addToSharedPreferences(String country) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, country).apply();
//    }
}