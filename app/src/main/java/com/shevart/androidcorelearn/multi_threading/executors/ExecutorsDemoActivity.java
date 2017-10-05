package com.shevart.androidcorelearn.multi_threading.executors;

import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class ExecutorsDemoActivity extends AbsActivity {
    private DemoStartable asyncQueueExecutorDemo = new SimpleQueueExecutorDemo();
    private DemoStartable fixedThreadPoolDemo = new FixedThreadPoolDemo();

    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UiNotificationsUtils.Extra.developerSeeToLogsMsg(ExecutorsDemoActivity.this);
            switch (v.getId()) {
                case R.id.btSimpleQueueExecutor:
                    asyncQueueExecutorDemo.startDemo();
                    break;
                case R.id.btFixedThreadPool:
                    fixedThreadPoolDemo.startDemo();
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executors_demo);
        enableToolbarBackButton();

        findViewById(R.id.btSimpleQueueExecutor).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btFixedThreadPool).setOnClickListener(buttonsClickListener);
    }
}