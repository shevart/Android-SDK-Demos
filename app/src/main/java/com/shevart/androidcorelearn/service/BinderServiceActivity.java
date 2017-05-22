package com.shevart.androidcorelearn.service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.service.service_not_sticky.BinderService;

public class BinderServiceActivity extends AppCompatActivity {
    private BinderService.MyBinder myBinder;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_service);
    }
}
