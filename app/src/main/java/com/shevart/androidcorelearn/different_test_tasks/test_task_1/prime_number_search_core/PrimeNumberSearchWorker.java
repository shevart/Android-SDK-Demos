package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.IntervalUtil;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.PrimeNumberUtil;
import com.shevart.androidcorelearn.utils.LogUtil;

class PrimeNumberSearchWorker implements Runnable {
    private PrimeNumberBuffer primeNumberBuffer;
    private Interval interval;

    PrimeNumberSearchWorker(@NonNull PrimeNumberBuffer buffer, @NonNull Interval interval) {
        primeNumberBuffer = buffer;
        this.interval = interval;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("search-prime_number-intervalId_" + interval.getId());
        if (IntervalUtil.isValidInterval(interval)) {
            for (int i = interval.getLow(); i <= interval.getHigh(); i++) {
                if (PrimeNumberUtil.isPrimeNumber(i)) {
                    primeNumberBuffer.addNewPrimeNumber(new PrimeNumber(interval.getId(), i));
                }
            }
        }
        finish();
    }

    private void finish() {
        // TODO: 09.10.17 add logic here
        LogUtil.e("finish() " + Thread.currentThread().getName());
    }
}