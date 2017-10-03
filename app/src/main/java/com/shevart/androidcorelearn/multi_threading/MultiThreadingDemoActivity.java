package com.shevart.androidcorelearn.multi_threading;

import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;

public class MultiThreadingDemoActivity extends AbsActivity {
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btSimpleThreads:

                    break;
                case R.id.btHandlerLooper:

                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_threading_demo);
        enableToolbarBackButton();
        findViewById(R.id.btSimpleThreads).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btHandlerLooper).setOnClickListener(buttonsClickListener);
    }
}