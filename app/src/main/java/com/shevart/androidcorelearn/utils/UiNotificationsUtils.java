package com.shevart.androidcorelearn.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.compat.BuildConfig;
import android.util.Log;
import android.widget.Toast;

@SuppressWarnings("WeakerAccess")
public class UiNotificationsUtils {
    // TODO: 09.05.17 use gradle and BuildConfig flag
    private static boolean isDebug = true;

    public static void showEmptyToast(@NonNull Context context, @NonNull String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showDevMessage(@NonNull Context context, @NonNull String msg) {
        if (isDebug) {
            showEmptyToast(context, msg);
            LogUtil.e(msg);
        }
    }

    public static class Extra {
        public static void developerSeeToLogsMsg(@NonNull Context context) {
            showDevMessage(context, "Developer, go to logs!");
        }
    }
}
