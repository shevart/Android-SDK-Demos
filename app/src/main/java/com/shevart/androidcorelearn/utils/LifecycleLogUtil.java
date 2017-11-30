package com.shevart.androidcorelearn.utils;

import android.support.annotation.NonNull;

import java.util.Locale;

public class LifecycleLogUtil {
    private static final String LOG_PATTERN = "<--%s-->: %s";

    public static void logMessage(@NonNull String name, @NonNull String msg) {
        LogUtil.INSTANCE.e(String.format(Locale.ENGLISH, LOG_PATTERN, name, msg));
    }
}