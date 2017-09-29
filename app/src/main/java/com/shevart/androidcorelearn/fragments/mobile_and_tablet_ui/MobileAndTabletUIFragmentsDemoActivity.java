package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;

public class MobileAndTabletUIFragmentsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_and_tablet_uifragments_demo);
    }

    void onItemSelected(@NonNull SimpleItem item) {

    }
}