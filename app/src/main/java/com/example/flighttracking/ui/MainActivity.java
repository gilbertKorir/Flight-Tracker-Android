package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.flighttracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.countryButton)
    Button mFindCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindCountry.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v) {
        if (v == mFindCountry) {
            Intent intent = new Intent(MainActivity.this, FlightsActivity.class);
            startActivity(intent);
        }
    }
}