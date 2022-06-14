package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FlightAdapter;
import com.example.flighttracking.models.flights.ConfirmFlight;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusDisplayActivity extends AppCompatActivity {
    private FlightAdapter mFlightadapter;
    @BindView(R.id.myrecycle) RecyclerView mRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_display);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String iata = intent.getStringExtra("iata");

        AirApi client = AirClient.getClient();
        Call<ConfirmFlight> call = client.getFlight(iata, Constants.AIR_API_KEY);

        call.enqueue(new Callback<ConfirmFlight>() {
            @Override
            public void onResponse(Call<ConfirmFlight> call, Response<ConfirmFlight> response) {

                com.example.flighttracking.models.flights.Response mList = response.body().getResponse();

                FlightAdapter flightAdapter = new FlightAdapter(StatusDisplayActivity.this, mList);
                mRecycle.setAdapter(flightAdapter);
//                   myCountryAdapter.setResultList(mList);
                mRecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onFailure(Call<ConfirmFlight> call, Throwable t) {

            }
        });
    }
}