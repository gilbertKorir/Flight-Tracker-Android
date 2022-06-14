package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AirportDetailFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.airportView) TextView mViewairport;
    @BindView(R.id.iataView) TextView mViewiata;
    @BindView(R.id.icaoView) TextView mViewicao;
    @BindView(R.id.latView) TextView mViewlat;
    @BindView(R.id.longView) TextView mViewlong;
    @BindView(R.id.slugView) TextView mViewslug;
    @BindView(R.id.cityView) TextView mViewcity;
    @BindView(R.id.popularView) TextView mViewpopular;
    @BindView(R.id.airportImageView) ImageView mImageview;
    @BindView(R.id.saveAirport) Button mSaveAirport;

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

        Picasso.get().load("https://www.nationsonline.org/gallery/USA/Dallas-Fort-Worth-International-Airport-Terminal-D.jpg").into(mImageview);
        mViewairport.setText(mAirport.getName());
        mViewiata.setText(mAirport.getIataCode());
        mViewicao.setText(mAirport.getIcaoCode());
        mViewlat.setText(mAirport.getLat().toString());
        mViewlong.setText(mAirport.getLng().toString());
        mViewslug.setText(mAirport.getSlug());
        mViewcity.setText(mAirport.getCityCode());
        mViewpopular.setText(mAirport.getPopularity().toString());

        mSaveAirport.setOnClickListener(this);
        return view;

    }
    @Override
    public void onClick(View v) {
        if (v == mSaveAirport) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference airportRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_AIRPORTS)
                    .child(uid);
            DatabaseReference pushRef = airportRef.push();
            String pushId = pushRef.getKey();
            mAirport.setPushId(pushId);
            pushRef.setValue(mAirport);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}