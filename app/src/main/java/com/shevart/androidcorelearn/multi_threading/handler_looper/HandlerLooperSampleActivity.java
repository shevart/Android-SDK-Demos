package com.shevart.androidcorelearn.multi_threading.handler_looper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample.HandlerBackgroundWorkerSampleActivity;
import com.shevart.androidcorelearn.multi_threading.handler_looper.handler_delayed_messages.HandlerDelayedActivity;

public class HandlerLooperSampleActivity extends AbsActivity {
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btSimpleHandlerSample:
                    startActivity(new Intent(HandlerLooperSampleActivity.this, HandlerBackgroundWorkerSampleActivity.class));
                    break;
                case R.id.btDelayedMessagesSample:
                    startActivity(new Intent(HandlerLooperSampleActivity.this, HandlerDelayedActivity.class));
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_looper_sample);
        enableToolbarBackButton();

        findViewById(R.id.btSimpleHandlerSample).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btDelayedMessagesSample).setOnClickListener(buttonsClickListener);
    }
}