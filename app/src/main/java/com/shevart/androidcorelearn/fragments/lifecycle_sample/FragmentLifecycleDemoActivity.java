package com.shevart.androidcorelearn.fragments.lifecycle_sample;

import android.app.Fragment;
import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.FragmentUtil;
import com.shevart.androidcorelearn.utils.LifecycleLogUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class FragmentLifecycleDemoActivity extends AbsActivity {
    private static final String TAG = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle_demo);
        enableToolbarBackButton();

        UiNotificationsUtils.INSTANCE.showToast(this, "See logs!");
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onCreate()");
        FragmentUtil.INSTANCE.addFragment(getSupportFragmentManager(),
                new LifecycleAddedDemoFragmentFragment(),
                R.id.flFragmentLifecycleContainer);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onRestoreInstanceState()");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onAttachFragment(), " + fragment.getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LifecycleLogUtil.INSTANCE.logMessage(TAG, "onDestroy()");
    }
}