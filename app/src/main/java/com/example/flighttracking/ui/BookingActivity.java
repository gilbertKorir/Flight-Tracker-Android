package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.flighttracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.personName) TextView mPerson;
    @BindView(R.id.startingPoint) TextView mStart;
    @BindView(R.id.endPoint) TextView mEnd;
    @BindView(R.id.departDate) TextView mDepart;
    @BindView(R.id.returnDate) TextView mReturn;
    @BindView(R.id.economyClass) TextView mEconomy;
    @BindView(R.id.codeEnter) TextView mCode;
    @BindView(R.id.submitData) Button mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
//        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_booking);

        ButterKnife.bind(this);

        mData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mData){
            String name = mPerson.getText().toString();
            String date = mDepart.getText().toString();
            Intent intent = new Intent(BookingActivity.this, FinalActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("date", date);
            startActivity(intent);
        }
    }
}