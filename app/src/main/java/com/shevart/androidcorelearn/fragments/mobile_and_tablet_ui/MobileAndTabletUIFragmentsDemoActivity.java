package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.utils.FragmentUtil;
import com.shevart.androidcorelearn.utils.MockUtils;

import java.util.ArrayList;

public class MobileAndTabletUIFragmentsDemoActivity extends AppCompatActivity {
    private ListScreenFragment fragmentList;
    private DetailScreenFragment fragmentDetail;
    private ArrayList<SimpleItem> items = MockUtils.SimpleItems.generateSimpleItemsList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_and_tablet_uifragments_demo);

        final boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        fragmentList = ListScreenFragment.getInstance(items);

        if (!isTablet) {
            FragmentUtil.replaceFragment(getSupportFragmentManager(), fragmentList, R.id.flContainer);
        } else {
            fragmentDetail = DetailScreenFragment.getInstance(items.get(0));
            FragmentUtil.replaceFragment(getSupportFragmentManager(), fragmentList, R.id.flList);
            FragmentUtil.replaceFragment(getSupportFragmentManager(), fragmentDetail, R.id.flDetail);
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