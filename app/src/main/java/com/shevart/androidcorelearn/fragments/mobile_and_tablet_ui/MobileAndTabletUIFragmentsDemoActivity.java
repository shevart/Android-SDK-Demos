package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.utils.MockUtils;

public class MobileAndTabletUIFragmentsDemoActivity extends AppCompatActivity {
    private ListScreenFragment fragmentList;
    @Nullable
    private DetailScreenFragment fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_and_tablet_uifragments_demo);

        fragmentList = (ListScreenFragment) getSupportFragmentManager().findFragmentById(R.id.fragList);
        if (getSupportFragmentManager().findFragmentById(R.id.fragDetail) != null)
            fragmentDetail = (DetailScreenFragment) getSupportFragmentManager().findFragmentById(R.id.fragDetail);

        fragmentList.updateItems(MockUtils.SimpleItems.generateSimpleItemsList());
    }

    void onItemSelected(@NonNull SimpleItem item) {
        if (fragmentDetail != null) {

        } else {

        }
    }
}