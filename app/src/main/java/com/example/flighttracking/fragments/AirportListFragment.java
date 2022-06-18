package com.example.flighttracking.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

//import androidx.core.view.MenuItemCompat;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.SpecificRecyclerAdapter;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.models.portsbycountry.AirportsSearch;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;
import com.example.flighttracking.ui.SpecificAirportActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class AirportListFragment extends Fragment {
    @BindView(R.id.search_results) RecyclerView searchResults;
    private SpecificRecyclerAdapter mAdapter;
    public ArrayList<AirportsByCountry> mAirports = new ArrayList<>();
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;


    public AirportListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mSharedPreferences.edit();

        // Instructs fragment to include menu options:
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_airport_list, container, false);
        ButterKnife.bind(this, view);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);

        if (mRecentAddress != null) {
            fetchAirports(mRecentAddress);
        }
        return view;
    }
    @Override
    // Method is now void, menu inflater is now passed in as argument:
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Call super to inherit method from parent:
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                fetchAirports(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //fetch airports
    private void fetchAirports(String country) {
        AirApi client = AirClient.getClient();
        Call<AirportsSearch> call = client.getSpecific(country, Constants.AIR_API_KEY);

        call.enqueue(new Callback<AirportsSearch>() {
            @Override
            public void onResponse(Call<AirportsSearch> call, retrofit2.Response<AirportsSearch> response) {
//                hideProgressBar();
                if (response.isSuccessful()) {
//                    mAdapter = new SpecificRecyclerAdapter(getActivity(), mAirports);
//                    searchResults.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                    searchResults.setLayoutManager(layoutManager);
//                    searchResults.setHasFixedSize(true);
                    mAirports = (ArrayList<AirportsByCountry>) response.body().getResponse().getAirportsByCountries();

                    mAdapter = new SpecificRecyclerAdapter(getContext(), mAirports);
                    searchResults.setAdapter(mAdapter);
//                   myCountryAdapter.setResultList(mList);
                    searchResults.setLayoutManager(new LinearLayoutManager(getActivity()));
                    searchResults.setHasFixedSize(true);
                } else {
//                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<AirportsSearch> call, Throwable t) {
                Log.e("TAG", "onFailure: ", t);
//                hideProgressBar();
//                showFailureMessage();
            }
        });
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}