package com.example.flighttracking.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.flighttracking.fragments.AirportDetailFragment;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;

import java.util.List;

public class AiportPageAdapter extends FragmentPagerAdapter {
    private List<AirportsByCountry> mAirports;

    public AiportPageAdapter(@NonNull FragmentManager fm, int behavior, List<AirportsByCountry> airports) {
        super(fm, behavior);
        this.mAirports = airports;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return AirportDetailFragment.newInstance(mAirports.get(position));
    }

    @Override
    public int getCount() {
        return mAirports.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mAirports.get(position).getName();
    }
}
