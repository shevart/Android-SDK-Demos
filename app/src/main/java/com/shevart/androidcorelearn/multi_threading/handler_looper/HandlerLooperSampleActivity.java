package com.shevart.androidcorelearn.multi_threading.handler_looper;

import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;

public class HandlerLooperSampleActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_looper_sample);
        enableToolbarBackButton();
    }
}