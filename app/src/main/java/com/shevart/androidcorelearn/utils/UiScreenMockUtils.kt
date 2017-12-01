package com.shevart.androidcorelearn.utils

import android.support.v4.app.Fragment

import com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui.DetailScreenFragment

object UiScreenMockUtils {
    fun nextDetailSimpleItemFragment(): Fragment {
        return DetailScreenFragment.getInstance(
                MockUtils.SimpleItems.generateSimpleItem())
    }
}
