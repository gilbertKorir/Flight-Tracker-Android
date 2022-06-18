package com.example.flighttracking.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FirebaseAirportListAdapter;
import com.example.flighttracking.adapters.FirebaseAirportViewHolder;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.utils.OnStartDragListener;
import com.example.flighttracking.utils.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedAirportListActivity extends AppCompatActivity {

    private DatabaseReference mAirportReference;
//    private FirebaseRecyclerAdapter<AirportsByCountry, FirebaseAirportViewHolder> mFirebaseAdapter;
//    private DatabaseReference mRestaurantReference;
    private FirebaseAirportListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
//
//    @BindView(R.id.search_results) RecyclerView searchResults;
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_airport_list);
//        ButterKnife.bind(this);

//        setUpFirebaseAdapter();
//        hideProgressBar();
//        showRestaurants();
    }
//    private void setUpFirebaseAdapter(){
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        Query query = FirebaseDatabase.getInstance()
//                .getReference(Constants.FIREBASE_CHILD_AIRPORTS)
//                .child(uid)
//                .orderByChild(Constants.FIREBASE_QUERY_INDEX);
//
//        FirebaseRecyclerOptions<AirportsByCountry> options =
//                new FirebaseRecyclerOptions.Builder<AirportsByCountry>()
//                        .setQuery(query, AirportsByCountry.class)
//                        .build();
//
////        mAirportReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_AIRPORTS).child(uid);
//
//        mFirebaseAdapter = new FirebaseAirportListAdapter(options, query, this, this);
//
//        searchResults.setLayoutManager(new LinearLayoutManager(this));
//        searchResults.setAdapter(mFirebaseAdapter);
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(searchResults);
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//    private void showRestaurants() {
//       searchResults.setVisibility(View.VISIBLE);
//    }
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        mItemTouchHelper.startDrag(viewHolder);
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.stopListening(); }
}