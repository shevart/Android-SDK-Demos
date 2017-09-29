package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

public class MobileAndTabletUIFragmentsDemoActivity extends AppCompatActivity {
    private ListScreenFragment fragmentList;
    @Nullable
    private DetailScreenFragment fragmentDetail;
    private ArrayList<SimpleItem> items = MockUtils.SimpleItems.generateSimpleItemsList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_and_tablet_uifragments_demo);

        fragmentList = (ListScreenFragment) getSupportFragmentManager().findFragmentById(R.id.fragList);
        if (getSupportFragmentManager().findFragmentById(R.id.fragDetail) != null)
            fragmentDetail = (DetailScreenFragment) getSupportFragmentManager().findFragmentById(R.id.fragDetail);

        fragmentList.updateItems(items);
        if (fragmentDetail != null) {
            fragmentDetail.update(items.get(0));
        }
    }

    void onItemSelected(@NonNull SimpleItem item) {
        if (fragmentDetail != null) {
            fragmentDetail.update(item);
        } else {
            final Intent intent = new Intent(this, DetailScreenActivity.class);
            final Bundle args = new Bundle();
            args.putParcelable(SimpleItem.class.getSimpleName(), item);
            intent.putExtras(args);
            startActivity(intent);
        }
    }
}