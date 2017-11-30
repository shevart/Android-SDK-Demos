package com.shevart.androidcorelearn.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.Launcher;
import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.service.service_not_sticky.NotStickyService;

public class ServiceLearnActivity extends AbsActivity {
    private View.OnClickListener serviceClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btStartNotStickyService:
                    startService(new Intent(ServiceLearnActivity.this, NotStickyService.class));
                    break;
                case R.id.btStartBinderServiceScreen:
                    startActivity(new Intent(ServiceLearnActivity.this, BinderServiceActivity.class));
                    break;
                default:
                    throw new IllegalArgumentException("Handle it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_learn);
        enableToolbarBackButton();
        findViewById(R.id.btStartNotStickyService).setOnClickListener(serviceClickListener);
        findViewById(R.id.btStartBinderServiceScreen).setOnClickListener(serviceClickListener);
    }
}
