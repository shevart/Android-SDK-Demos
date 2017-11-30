package com.shevart.androidcorelearn.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

@SuppressWarnings("WeakerAccess")
public class UiNotificationsUtils {
    private static boolean debug = true;

    public static void showToast(@NonNull Context context, @NonNull String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showDevMessage(@NonNull Context context, @NonNull String msg) {
        if (debug) {
            showToast(context, msg);
            LogUtil.INSTANCE.e(msg);
        }
    }

    public static class Extra {
        public static void developerSeeToLogsMsg(@NonNull Context context) {
            showDevMessage(context, "Developer, go to logs!");
        }
    }
}
