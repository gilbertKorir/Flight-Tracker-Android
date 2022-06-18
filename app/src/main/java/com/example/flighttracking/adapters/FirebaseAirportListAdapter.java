package com.example.flighttracking.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.utils.ItemTouchHelperAdapter;
import com.example.flighttracking.utils.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class FirebaseAirportListAdapter extends FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseAirportListAdapter(@NonNull FirebaseRecyclerOptions<AirportsByCountry> options,
                                      DatabaseReference ref,
                                      OnStartDragListener onStartDragListener,
                                      Context context) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseAirportViewHolder holder, int position, @NonNull AirportsByCountry model) {

    }

    @NonNull
    @Override
    public FirebaseAirportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
