package com.example.flighttracking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flighttracking.Constants;
import com.example.flighttracking.R;
import com.example.flighttracking.adapters.FirebaseAirportListAdapter;
import com.example.flighttracking.models.portsbycountry.AirportsByCountry;
import com.example.flighttracking.utils.OnStartDragListener;
import com.example.flighttracking.utils.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SavedAirportListFragment extends Fragment implements OnStartDragListener {
    @BindView(R.id.search_results) RecyclerView searchResults;
    private FirebaseAirportListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;


    public SavedAirportListFragment() {
        // Required empty public constructor
    }

//    public static SavedAirportListFragment newInstance(String param1, String param2) {
//        SavedAirportListFragment fragment = new SavedAirportListFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_aiport_list, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }
    private void setUpFirebaseAdapter(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_AIRPORTS)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        FirebaseRecyclerOptions<AirportsByCountry> options =
                new FirebaseRecyclerOptions.Builder<AirportsByCountry>()
                        .setQuery(query, AirportsByCountry.class)
                        .build();

//        mAirportReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_AIRPORTS).child(uid);
        mFirebaseAdapter = new FirebaseAirportListAdapter(options, query, this, getActivity());
        searchResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchResults.setAdapter(mFirebaseAdapter);
        searchResults.setHasFixedSize(true);

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                mFirebaseAdapter.notifyDataSetChanged();
            }
        });
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(searchResults);
    }
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
    @Override
    //method is now public
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.stopListening();
    }
}