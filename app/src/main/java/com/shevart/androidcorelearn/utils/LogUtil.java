package com.shevart.androidcorelearn.utils;

import android.support.annotation.NonNull;
import android.util.Log;

@SuppressWarnings("unused")
public class LogUtil {
    private static final String TAG = "<-- CoreLearnTag -->";

    public static void e(@NonNull String e) {
        Log.e(TAG, e);
    }

    public static void e(@NonNull Throwable e) {
        e.printStackTrace();
    }

    public static void d(@NonNull String e) {
        Log.d(TAG, e);
    }
}
