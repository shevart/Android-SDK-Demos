package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberSearcher {
    private ExecutorService executorService;
    private PrimeNumberBuffer primeNumberBuffer;

    public PrimeNumberSearcher() {
        primeNumberBuffer = new PrimeNumberBuffer();
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void searchPrimeNumbers(@NonNull List<Interval> intervals) {

        for (Interval interval : intervals) {
            executorService.execute(new PrimeNumberSearchWorker(primeNumberBuffer, interval));
        }
    }
}