package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.flighttracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinalActivity extends AppCompatActivity {
    @BindView(R.id.finalEdit) TextView mfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String date = intent.getStringExtra("date");
        mfinal.setText("Thank You " + name + " for Booking with us, kindly visit us one day to your depature date" + date);
    }
}