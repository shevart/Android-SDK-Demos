package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberSearcher implements PrimeNumbersCallback {
    private ExecutorService executorService;
    private PrimeNumberBuffer primeNumberBuffer;
    private PrimeNumberStoringThread primeNumberStoringThread;
    private PrimeNumbersCallback primeNumbersCallback;

    public PrimeNumberSearcher() {
        primeNumberBuffer = new PrimeNumberBuffer();
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        primeNumberStoringThread = new PrimeNumberStoringThread(primeNumberBuffer, this);
    }

    public void searchPrimeNumbers(@NonNull List<Interval> intervals) {
        primeNumberStoringThread.start();
        for (Interval interval : intervals) {
            executorService.execute(new PrimeNumberSearchWorker(primeNumberBuffer, interval));
        }
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