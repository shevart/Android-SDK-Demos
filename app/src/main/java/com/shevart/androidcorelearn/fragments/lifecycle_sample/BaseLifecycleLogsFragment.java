package com.shevart.androidcorelearn.fragments.lifecycle_sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.utils.LifecycleLogUtil;

public abstract class BaseLifecycleLogsFragment extends Fragment {
    public BaseLifecycleLogsFragment() {

    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        logMessage("onInflate(), context");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        logMessage("onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logMessage("onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logMessage("onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logMessage("onViewCreated()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logMessage("onActivityCreated()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        logMessage("onViewStateRestored()");
    }

    @Override
    public void onStart() {
        super.onStart();
        logMessage("onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        logMessage("onResume()");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        logMessage("onCreateOptionsMenu()");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        logMessage("onPrepareOptionsMenu()");
    }

    @Override
    public void onPause() {
        super.onPause();
        logMessage("onPause()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logMessage("onSaveInstanceState()");
    }

    @Override
    public void onStop() {
        super.onStop();
        logMessage("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logMessage("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logMessage("onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logMessage("onDetach()");
    }

    /***
     * <h3>Developer hint</h3>
     * Use this method only for logging {@link Fragment} lifecycle methods and public constructor
     * @param msg - String which will be print in logs
     */
    protected void logMessage(@NonNull String msg) {
        LifecycleLogUtil.INSTANCE.logMessage(provideFragmentName(), msg);
    }

    protected abstract String provideFragmentName();
}
