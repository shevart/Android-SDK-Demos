package com.shevart.androidcorelearn.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentUtil {
    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment,
                                       @IdRes int containerId) {
        fragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }
}
