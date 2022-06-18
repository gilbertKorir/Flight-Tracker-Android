package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.flighttracking.R;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.utils.ItemTouchHelperAdapter;
import com.example.flighttracking.utils.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseAirportListAdapter extends FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder>
        implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    private ChildEventListener mChildEventListener;
    private ArrayList<AirportsByCountry> mAirports = new ArrayList<>();

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
    protected void onBindViewHolder(@NonNull FirebaseAirportViewHolder firebaseAirportViewHolder, int position, @NonNull AirportsByCountry airport) {
        firebaseAirportViewHolder.bindSpecific(airport);
        firebaseAirportViewHolder.mNameview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(firebaseAirportViewHolder);
                }
                return false;
            }
        });
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
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mAirports.remove(position);
        getRef(position).removeValue();
    }
}