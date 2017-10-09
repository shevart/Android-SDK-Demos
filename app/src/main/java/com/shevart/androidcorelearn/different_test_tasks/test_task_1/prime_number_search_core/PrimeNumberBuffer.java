package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

import java.util.ArrayDeque;
import java.util.Queue;

class PrimeNumberBuffer {
    private Queue<PrimeNumber> primeNumbersQueue = new ArrayDeque<>();

    synchronized void addNewPrimeNumber(@NonNull PrimeNumber primeNumber) {
        primeNumbersQueue.add(primeNumber);
        notify();
    }

    synchronized PrimeNumber getPrimeNumber() {
        PrimeNumber result;
        while ((result = primeNumbersQueue.poll()) == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO: 09.10.17 handle it
                e.printStackTrace();
            }
        }
        return result;
    }
}
