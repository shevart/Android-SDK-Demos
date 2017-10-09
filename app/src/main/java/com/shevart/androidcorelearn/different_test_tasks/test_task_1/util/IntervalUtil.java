package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;

public class IntervalUtil {
    public static boolean isValidInterval(@NonNull Interval interval) {
        return interval.getHigh() > interval.getLow();
    }
}
