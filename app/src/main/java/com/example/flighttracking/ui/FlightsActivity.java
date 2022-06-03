package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flighttracking.Constants;
import com.example.flighttracking.adapters.MyCountryAdapter;
import com.example.flighttracking.R;
import com.example.flighttracking.models.CountrySearchResponse;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightsActivity extends AppCompatActivity {

    private MyCountryAdapter mDisplayAdapter;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        ButterKnife.bind(this);

        AirApi client = AirClient.getClient();
        Call<CountrySearchResponse> call = client.getCountry(Constants.AIR_API_KEY);

        call.enqueue(new Callback<CountrySearchResponse>() {
            @Override
            public void onResponse(Call<CountrySearchResponse> call, Response<CountrySearchResponse> response) {

                if(response.isSuccessful()){

                    List<com.example.flighttracking.models.Response> mList = response.body().getResponse();

                   MyCountryAdapter myCountryAdapter = new MyCountryAdapter(FlightsActivity.this, mList);
                   mRecyclerView.setAdapter(myCountryAdapter);
//                   myCountryAdapter.setResultList(mList);
                   mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
               }
            }

            @Override
            public void onFailure(Call<CountrySearchResponse> call, Throwable t) {

            }


            private void showCountry() {
//                mListView.setVisibility(View.VISIBLE);
//                mCountryTextView.setVisibility(View.VISIBLE);
            }

        });

    }
}
