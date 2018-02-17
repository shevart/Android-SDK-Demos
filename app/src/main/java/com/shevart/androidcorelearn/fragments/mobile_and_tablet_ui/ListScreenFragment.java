package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.common.SimpleItemsRVAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListScreenFragment extends Fragment implements SimpleItemsRVAdapter.OnSimpleItemSelectedListener {
    private static final String LIST_ITEMS_KEY = "list_items_key";
    private SimpleItemsRVAdapter adapter;

    public ListScreenFragment() {
    }

    public static ListScreenFragment getInstance(@NonNull ArrayList<SimpleItem> items) {
        final ListScreenFragment fragment = new ListScreenFragment();
        final Bundle args = new Bundle();
        args.putParcelableArrayList(LIST_ITEMS_KEY, items);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_screen, container, false);
        adapter = new SimpleItemsRVAdapter(this, getItemsFromArguments(), false);
        RecyclerView rvSimpleItems = view.findViewById(R.id.rvSimpleItems);
        rvSimpleItems.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSimpleItems.setAdapter(adapter);
        return view;
    }

    private List<SimpleItem> getItemsFromArguments() {
        if (getArguments() != null)
            return getArguments().getParcelableArrayList(LIST_ITEMS_KEY);
        else
            return Collections.emptyList();
    }

    @Override
    public void onSimpleItemSelected(@NonNull SimpleItem simpleItem) {
        ((MobileAndTabletUIFragmentsDemoActivity) getActivity()).onItemSelected(simpleItem);
    }

    @SuppressWarnings("unused")
    void updateItems(@NonNull ArrayList<SimpleItem> items) {
        adapter.update(items);
    }
}