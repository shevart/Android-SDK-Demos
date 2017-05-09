package com.shevart.androidcorelearn.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.service.service_not_sticky.NotStickyService;

public class ServiceLearnActivity extends AppCompatActivity {
    private View.OnClickListener serviceClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btStartNotStickyService:
                    startService(new Intent(ServiceLearnActivity.this, NotStickyService.class));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_learn);
        findViewById(R.id.btStartNotStickyService).setOnClickListener(serviceClickListener);
    }
}
