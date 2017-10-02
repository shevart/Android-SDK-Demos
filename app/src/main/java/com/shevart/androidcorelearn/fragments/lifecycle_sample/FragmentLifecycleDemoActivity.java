package com.shevart.androidcorelearn.fragments.lifecycle_sample;

import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.FragmentUtil;

public class FragmentLifecycleDemoActivity extends AbsActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle_demo);
        enableToolbarBackButton();

        FragmentUtil.addFragment(getSupportFragmentManager(),
                new LifecycleAddedDemoFragmentFragment(),
                R.id.flFragmentLifecycleContainer);
    }
}