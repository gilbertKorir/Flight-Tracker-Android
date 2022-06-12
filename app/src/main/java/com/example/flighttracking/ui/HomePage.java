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

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.getStart) Button mGetstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);

        mGetstart.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v==mGetstart) {
            Intent intent = new Intent(HomePage.this, CreateAccountActivity.class);
            startActivity(intent);
        }
    }
}
//FOR MOST PEOPLE THE SKY IS THE LIMIT. FOR FLIGHT ATTENDANTS THE SKY IS HOME.
//Good things comes to those who book flights.
