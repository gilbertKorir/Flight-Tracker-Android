package com.example.flighttracking.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.AiportPageAdapter;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AirportsDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private AiportPageAdapter adapterViewPager;
    ArrayList<AirportsByCountry> mAirports = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airports_detail);

        ButterKnife.bind(this);

        mAirports = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_KEY_AIRPORTS));
        int startingPosition = getIntent().getIntExtra("position", 0);
//        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new AiportPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mAirports);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}