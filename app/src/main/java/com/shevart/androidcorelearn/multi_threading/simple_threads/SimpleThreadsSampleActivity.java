package com.shevart.androidcorelearn.multi_threading.simple_threads;

import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class SimpleThreadsSampleActivity extends AbsActivity {
    private DemoStartable waitNotifyDemo = new WaitNotifyThreadsSimpleDemo();
    private DemoStartable stopThreadDemo = new StopThreadSimpleDemo();

    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UiNotificationsUtils.showDevMessage(SimpleThreadsSampleActivity.this, "Developer, go to logs!");
            switch (v.getId()) {
                case R.id.btWaitNotifyDemo:
                    waitNotifyDemo.startDemo();
                    break;
                case R.id.btStoppingThread:
                    stopThreadDemo.startDemo();
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_threads_sample);
        enableToolbarBackButton();

        findViewById(R.id.btWaitNotifyDemo).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btStoppingThread).setOnClickListener(buttonsClickListener);
    }
}