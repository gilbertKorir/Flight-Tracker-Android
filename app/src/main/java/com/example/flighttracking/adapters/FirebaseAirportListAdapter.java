package com.example.flighttracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.fragments.AirportDetailFragment;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.ui.AirportsDetailActivity;
import com.example.flighttracking.utils.ItemTouchHelperAdapter;
import com.example.flighttracking.utils.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseAirportListAdapter extends FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder>
        implements ItemTouchHelperAdapter {

    private Query mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<AirportsByCountry> mAirports = new ArrayList<>();
    private int mOrientation;

    public FirebaseAirportListAdapter(@NonNull FirebaseRecyclerOptions<AirportsByCountry> options,
                                      Query ref,
                                      OnStartDragListener onStartDragListener,
                                      Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mAirports.add(dataSnapshot.getValue(AirportsByCountry.class));
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onBindViewHolder(@NonNull final FirebaseAirportViewHolder viewHolder, int position, @NonNull AirportsByCountry airport) {
        viewHolder.bindSpecific(airport);


        mOrientation = viewHolder.itemView.getResources().getConfiguration().orientation;
        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            createDetailFragment(0);
        }

        viewHolder.mNameview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }

        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = viewHolder.getAdapterPosition();
                 if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                    createDetailFragment(itemPosition);
                } else {
                     Intent intent = new Intent(mContext, AirportsDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                    intent.putExtra(Constants.EXTRA_KEY_AIRPORTS, Parcels.wrap(mAirports));
                     intent.putExtra(Constants.KEY_SOURCE, Constants.SOURCE_SAVED);
                    mContext.startActivity(intent);
                }
//                intent.putExtra("position", viewHolder.getAdapterPosition());
//                intent.putExtra("airports", Parcels.wrap(mAirports));
//                mContext.startActivity(intent);
            }
        });
    }
    private void createDetailFragment(int position) {
        // Creates new RestaurantDetailFragment with the given position:
       AirportDetailFragment detailFragment = AirportDetailFragment.newInstance(mAirports, position, Constants.SOURCE_SAVED);
        // Gathers necessary components to replace the FrameLayout in the layout with the RestaurantDetailFragment:
        FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
        //  Replaces the FrameLayout with the RestaurantDetailFragment:
        ft.replace(R.id.airportDetailContainer, detailFragment);
        // Commits these changes:
        ft.commit();
    }

    @NonNull
    @Override
    public FirebaseAirportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specific_drag, parent, false);
        return new FirebaseAirportViewHolder(view);
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mAirports, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInForebase();
        return false;
    }

    private void setIndexInForebase() {
            for (AirportsByCountry airport : mAirports) {
                int index = mAirports.indexOf(airport);
                DatabaseReference ref = getRef(index);
                airport.setIndex(Integer.toString(index));
                ref.setValue(airport);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        mAirports.remove(position);
        getRef(position).removeValue();
    }
    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }

//    @Override
//    protected void onBindViewHolder(@NonNull final FirebaseAirportViewHolder vieHolder, int position, @NonNull AirportsByCountry model) {
//
//    }
}
