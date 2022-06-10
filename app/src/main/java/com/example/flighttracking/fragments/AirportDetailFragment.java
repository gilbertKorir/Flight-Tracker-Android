package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AirportDetailFragment extends Fragment {

    @BindView(R.id.airportView) TextView mViewairport;
    @BindView(R.id.iataView) TextView mViewiata;
    @BindView(R.id.icaoView) TextView mViewicao;
    @BindView(R.id.latView) TextView mViewlat;
    @BindView(R.id.longView) TextView mViewlong;
    @BindView(R.id.slugView) TextView mViewslug;
    @BindView(R.id.cityView) TextView mViewcity;
    @BindView(R.id.popularView) TextView mViewpopular;

    private AirportsByCountry mAirport;

    public AirportDetailFragment() {
        // Required empty public constructor
    }

    public static AirportDetailFragment newInstance(AirportsByCountry airport) {
        AirportDetailFragment airportDetailFragment = new AirportDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("airport", Parcels.wrap(airport));
        airportDetailFragment.setArguments(args);
        return airportDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAirport = Parcels.unwrap(getArguments().getParcelable("airport"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_airport_detail, container, false);
        ButterKnife.bind(this, view);

        mViewairport.setText(mAirport.getName());
        mViewiata.setText(mAirport.getIataCode());
        mViewicao.setText(mAirport.getIcaoCode());
        mViewlat.setText(mAirport.getLat().toString());
        mViewlong.setText(mAirport.getLng().toString());
        mViewslug.setText(mAirport.getSlug());
        mViewcity.setText(mAirport.getCityCode());
        mViewpopular.setText(mAirport.getPopularity());

        return view;

    }
}