package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberSearcher implements PrimeNumbersCallback {
    private PrimeNumbersCallback primeNumbersCallback;

    public PrimeNumberSearcher() {

    }

    public void searchPrimeNumbers(@NonNull List<Interval> intervals) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        PrimeNumberBridge primeNumberBridge = new PrimeNumberBridge(intervals.size());
        PrimeNumberStoringThread primeNumberStoringThread = new PrimeNumberStoringThread(primeNumberBridge, this);
        primeNumberStoringThread.start();
        for (Interval interval : intervals) {
            executorService.execute(new PrimeNumberSearchWorker(primeNumberBridge, interval));
        }
        executorService.shutdown();
    }

    public void setPrimeNumbersCallback(@NonNull PrimeNumbersCallback callback) {
        primeNumbersCallback = callback;
    }

    public void removePrimeNumbersCallback() {
        primeNumbersCallback = null;
    }

    @Override
    public void onNewPrimeNumberFound(@NonNull PrimeNumber primeNumber) {
        if (primeNumbersCallback != null)
            primeNumbersCallback.onNewPrimeNumberFound(primeNumber);
    }
}