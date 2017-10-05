package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;

@SuppressWarnings("FieldCanBeLocal")
public class HandlerBackgroundWorkerSampleActivity extends AbsActivity {
    static final int ON_JOB_COMPLETE_WHAT = 2;
    private WorkerThread workerThread;
    private Handler uiHandler;
    private int jobId = 1;

    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_background_worker_sample);
        enableToolbarBackButton();

        uiHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == ON_JOB_COMPLETE_WHAT) {
                    tvStatus.setText("Job with id:" + msg.arg1 + " is complete!");
                } else {
                    super.handleMessage(msg);
                }
            }
        };

        workerThread = new WorkerThread(uiHandler);
        workerThread.start();

        tvStatus = (TextView) findViewById(R.id.tvRunningJobsStatus);
        findViewById(R.id.btRunJob).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passToWorkerThreadSomeJob();
            }
        });
    }

    private void passToWorkerThreadSomeJob() {
        workerThread.runSomeJob(jobId++);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        workerThread.stopWork();
    }
}