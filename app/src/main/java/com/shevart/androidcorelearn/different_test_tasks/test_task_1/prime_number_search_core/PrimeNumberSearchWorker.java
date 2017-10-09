package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.IntervalUtil;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.PrimeNumberUtil;
import com.shevart.androidcorelearn.utils.LogUtil;

class PrimeNumberSearchWorker implements Runnable {
    private PrimeNumberBridge primeNumberBridge;
    private Interval interval;

    PrimeNumberSearchWorker(@NonNull PrimeNumberBridge buffer, @NonNull Interval interval) {
        primeNumberBridge = buffer;
        this.interval = interval;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("search-prime_number-intervalId_" + interval.getId());
        if (IntervalUtil.isValidInterval(interval)) {
            for (int i = interval.getLow(); i <= interval.getHigh(); i++) {
                if (PrimeNumberUtil.isPrimeNumber(i)) {
                    LogUtil.e("The primeNumber is found - " + i);
                    primeNumberBridge.addNewPrimeNumber(new PrimeNumber(interval.getId(), i));
                }
            }
        }
        finish();
    }

    private void finish() {
        LogUtil.e("finish() " + Thread.currentThread().getName());
        primeNumberBridge.onWorkerFinish();
    }
}