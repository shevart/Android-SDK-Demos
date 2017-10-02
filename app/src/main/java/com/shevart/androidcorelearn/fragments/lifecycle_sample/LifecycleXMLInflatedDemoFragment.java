package com.shevart.androidcorelearn.fragments.lifecycle_sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.R;

public class LifecycleXMLInflatedDemoFragment extends BaseLifecycleLogsFragment {
    private static final String TAG = "FromXML";

    public LifecycleXMLInflatedDemoFragment() {
        // Required empty public constructor
        logMessage("public constructor");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lifecycle_demo, container, false);
    }

    @Override
    protected String provideFragmentName() {
        return TAG;
    }
}