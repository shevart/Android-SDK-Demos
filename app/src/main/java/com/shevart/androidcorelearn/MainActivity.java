package com.shevart.androidcorelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity;
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity;
import com.shevart.androidcorelearn.multi_threading.test_task_1.TestTask1Activity;
import com.shevart.androidcorelearn.service.ServiceLearnActivity;

public class MainActivity extends AppCompatActivity {
    private View.OnClickListener launcherClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btServiceTopic:
                    startActivity(new Intent(MainActivity.this, ServiceLearnActivity.class));
                    break;
                case R.id.btFragmentsTopic:
                    startActivity(new Intent(MainActivity.this, FragmentsDemoActivity.class));
                    break;
                case R.id.btMultiThreads:
                    startActivity(new Intent(MainActivity.this, MultiThreadingDemoActivity.class));
                    break;
                default:
                    throw new IllegalArgumentException("Handle it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btServiceTopic).setOnClickListener(launcherClickListener);
        findViewById(R.id.btFragmentsTopic).setOnClickListener(launcherClickListener);
        findViewById(R.id.btMultiThreads).setOnClickListener(launcherClickListener);

        // TODO: 09.10.17 remove after test
        startActivity(new Intent(this, TestTask1Activity.class));
    }
}
