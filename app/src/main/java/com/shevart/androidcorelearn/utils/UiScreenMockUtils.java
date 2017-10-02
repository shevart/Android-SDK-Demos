package com.shevart.androidcorelearn.utils;

import android.support.v4.app.Fragment;

import com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui.DetailScreenFragment;

public class UiScreenMockUtils {
    public static Fragment nextDetailSimpleItemFragment() {
        return DetailScreenFragment.getInstance(
                MockUtils.SimpleItems.generateSimpleItem());
    }
}
