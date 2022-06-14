package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FlightAdapter;
import com.example.flighttracking.models.flights.ConfirmFlight;
import com.example.flighttracking.network.AirApi;
import com.example.flighttracking.network.AirClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iatastatus) EditText mIata;
    @BindView(R.id.iatabutton) Button mIatasearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        ButterKnife.bind(this);

        mIatasearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mIatasearch) {
            String iata = mIata.getText().toString();
            Intent intent = new Intent(StatusActivity.this, StatusDisplayActivity.class);
            intent.putExtra("iata", iata);
            startActivity(intent);
        }
    }
}