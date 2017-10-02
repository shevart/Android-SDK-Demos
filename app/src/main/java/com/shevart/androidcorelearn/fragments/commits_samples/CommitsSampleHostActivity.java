package com.shevart.androidcorelearn.fragments.commits_samples;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.AutoClosableActivity;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.lang.ref.WeakReference;
import java.util.Locale;

import static com.shevart.androidcorelearn.utils.UiScreenMockUtils.nextDetailSimpleItemFragment;

public class CommitsSampleHostActivity extends AbsActivity {
    private static final String LIFECYCLE_PATTERN = "Current state: %s";
    @SuppressWarnings("PointlessArithmeticExpression")
    private static final long DELAY = 1000 * 1;

    private CommitsHandler commitsHandler = new CommitsHandler(this);

    private TextView tvLifecycleState;
    private CheckBox cbOpenActivityBeforeCommits;
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (cbOpenActivityBeforeCommits.isChecked()) {
                startActivity(new Intent(CommitsSampleHostActivity.this, AutoClosableActivity.class));
                switch (v.getId()) {
                    case R.id.btCommit:
                        commitsHandler.sendEmptyMessageDelayed(CommitsHandler.WHAT_COMMIT, DELAY);
                        break;
                    case R.id.btCommitAllowingStateLoss:
                        commitsHandler.sendEmptyMessageDelayed(CommitsHandler.WHAT_COMMIT_ALLOWING_STATE_LOSS, DELAY);
                        break;
                    case R.id.btCommitNow:
                        commitsHandler.sendEmptyMessageDelayed(CommitsHandler.WHAT_COMMIT_NOW, DELAY);
                        break;
                    case R.id.btCommitNowAllowingStateLoss:
                        commitsHandler.sendEmptyMessageDelayed(CommitsHandler.WHAT_COMMIT_NOW_ALLOWING_STATE_LOSS, DELAY);
                        break;
                    default:
                        throw new IllegalArgumentException("Check it!");
                }
                return;
            }

            // without opening activity
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
        setContentView(R.layout.activity_commits_sample_host);
        enableToolbarBackButton();
        initView();
        displayCurrentLifecycleState("onCreate()");
    }

    private void initView() {
        tvLifecycleState = (TextView) findViewById(R.id.tvLifecycleState);
        cbOpenActivityBeforeCommits = (CheckBox) findViewById(R.id.cbOpenActivityBeforeCommits);
        findViewById(R.id.btCommit).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitAllowingStateLoss).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitNow).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btCommitNowAllowingStateLoss).setOnClickListener(buttonsClickListener);
    }



    private void sampleCommit() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommit()");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flCommitsContainer, nextDetailSimpleItemFragment())
                .commit();
    }

    private void sampleCommitAllowingStateLoss() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitAllowingStateLoss()");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flCommitsContainer, nextDetailSimpleItemFragment())
                .commitAllowingStateLoss();
    }

    private void sampleCommitNow() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitNow()");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flCommitsContainer, nextDetailSimpleItemFragment())
                .commitNow();
    }

    private void sampleCommitNowAllowingStateLoss() {
        UiNotificationsUtils.showDevMessage(this, "sampleCommitNowAllowingStateLoss()");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flCommitsContainer, nextDetailSimpleItemFragment())
                .commitNowAllowingStateLoss();
    }

    /***
     *
     *
     *  Lifecycle's methods block
     *
     *
     */
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        displayCurrentLifecycleState("onSaveInstanceState()");
    }

    private void displayCurrentLifecycleState(@NonNull String currLifecycle) {
        LogUtil.e("displayCurrentLifecycleState() - " + currLifecycle);
        tvLifecycleState.setText(String.format(Locale.ENGLISH, LIFECYCLE_PATTERN, currLifecycle));
    }

    private static class CommitsHandler extends Handler {
        static final int WHAT_COMMIT = 1;
        static final int WHAT_COMMIT_ALLOWING_STATE_LOSS = 2;
        static final int WHAT_COMMIT_NOW = 3;
        static final int WHAT_COMMIT_NOW_ALLOWING_STATE_LOSS = 4;

        private WeakReference<CommitsSampleHostActivity> activityWeakReference;

        CommitsHandler(@NonNull CommitsSampleHostActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (activityWeakReference.get() == null)
                return;
            switch (msg.what) {
                case WHAT_COMMIT:
                    activityWeakReference.get().sampleCommit();
                    break;
                case WHAT_COMMIT_ALLOWING_STATE_LOSS:
                    activityWeakReference.get().sampleCommitAllowingStateLoss();
                    break;
                case WHAT_COMMIT_NOW:
                    activityWeakReference.get().sampleCommitNow();
                    break;
                case WHAT_COMMIT_NOW_ALLOWING_STATE_LOSS:
                    activityWeakReference.get().sampleCommitNowAllowingStateLoss();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}