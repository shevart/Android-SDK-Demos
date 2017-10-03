package com.shevart.androidcorelearn.multi_threading.simple_threads;

import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;

public class SimpleThreadsSampleActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_threads_sample);
        enableToolbarBackButton();
    }
}