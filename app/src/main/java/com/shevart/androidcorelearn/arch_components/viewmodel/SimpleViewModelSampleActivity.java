package com.shevart.androidcorelearn.arch_components.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.common.SimpleItemsRVAdapter;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.util.ArrayList;
import java.util.List;

public class SimpleViewModelSampleActivity extends AbsActivity implements SimpleItemsRVAdapter.OnSimpleItemSelectedListener {
    private ProgressBar pbViewModelSampleLoading;
    private RecyclerView rvViewModelSample;
    private SimpleItemsRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_view_model_sample);
        enableToolbarBackButton();

        initViews();
        showLoading();

        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getListLiveData().observe(this, new Observer<List<SimpleItem>>() {
            @Override
            public void onChanged(@Nullable List<SimpleItem> simpleItems) {
                onSimpleItemsLoaded(simpleItems, adapter);
            }
        });
    }

    private void initViews() {
        pbViewModelSampleLoading = findViewById(R.id.pbViewModelSampleLoading);
        rvViewModelSample = findViewById(R.id.rvViewModelSample);
        adapter = new SimpleItemsRVAdapter(this, new ArrayList<SimpleItem>());
        rvViewModelSample.setLayoutManager(new LinearLayoutManager(this));
        rvViewModelSample.setAdapter(adapter);
    }

    private void onSimpleItemsLoaded(@Nullable List<SimpleItem> simpleItems, SimpleItemsRVAdapter adapter) {
        if (simpleItems != null) {
            adapter.update(simpleItems);
            showContent();
        }
    }


    @Override
    public void onSimpleItemSelected(@NonNull SimpleItem simpleItem) {
        UiNotificationsUtils.showToast(this, simpleItem.getTitle());
    }

    private void showLoading() {
        pbViewModelSampleLoading.setVisibility(View.VISIBLE);
        rvViewModelSample.setVisibility(View.GONE);
    }

    private void showContent() {
        pbViewModelSampleLoading.setVisibility(View.GONE);
        rvViewModelSample.setVisibility(View.VISIBLE);
    }
}