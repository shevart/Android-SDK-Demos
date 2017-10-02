package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.SimpleItem;

public class DetailScreenActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        enableToolbarBackButton();

        final DetailScreenFragment fragment = (DetailScreenFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetail);
        fragment.update(getSimpleItemFromIntent());
    }

    private SimpleItem getSimpleItemFromIntent() {
        return getIntent().getParcelableExtra(SimpleItem.class.getSimpleName());
    }
}