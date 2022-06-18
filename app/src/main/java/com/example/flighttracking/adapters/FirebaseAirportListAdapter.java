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
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
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
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        getRef(position).removeValue();
    }
}
