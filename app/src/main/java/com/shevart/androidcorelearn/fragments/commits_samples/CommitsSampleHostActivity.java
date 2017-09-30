package com.shevart.androidcorelearn.fragments.commits_samples;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.util.Locale;

public class CommitsSampleHostActivity extends AppCompatActivity {
    private static final String LIFECYCLE_PATTERN = "Current state: %s";
    private TextView tvLifecycleState;
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btCommit:
                    sampleCommit();
                    break;
                case R.id.btCommitAllowingStateLoss:
                    sampleCommitAllowingStateLoss();
                    break;
                case R.id.btCommitNow:
                    sampleCommitNow();
                    break;
                case R.id.btCommitNowAllowingStateLoss:
                    sampleCommitNowAllowingStateLoss();
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayCurrentLifecycleState("onCreate()");
        tvLifecycleState = (TextView) findViewById(R.id.tvLifecycleState);
        setContentView(R.layout.activity_commits_sample_host);
        findViewById(R.id.btCommit).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitAllowingStateLoss).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitNow).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitNowAllowingStateLoss).setOnClickListener(buttonsClickListener);
    }

    private void sampleCommit() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommit()");
    }

    private void sampleCommitAllowingStateLoss() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitAllowingStateLoss()");
    }

    private void sampleCommitNow() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitNow()");
    }

    private void sampleCommitNowAllowingStateLoss() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitNowAllowingStateLoss()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayCurrentLifecycleState("onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        displayCurrentLifecycleState("onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayCurrentLifecycleState("onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayCurrentLifecycleState("onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        displayCurrentLifecycleState("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        displayCurrentLifecycleState("onDestroy()");
    }

    private void displayCurrentLifecycleState(@NonNull String currLifecycle) {
        LogUtil.e("displayCurrentLifecycleState() - " + currLifecycle);
        tvLifecycleState.setText(String.format(Locale.ENGLISH, LIFECYCLE_PATTERN, currLifecycle));
    }
}