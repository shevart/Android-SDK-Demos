package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;

public class DetailScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        final DetailScreenFragment fragment = (DetailScreenFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetail);
        fragment.update(getSimpleItemFromIntent());
    }

    private SimpleItem getSimpleItemFromIntent() {
        return getIntent().getParcelableExtra(SimpleItem.class.getSimpleName());
    }
}