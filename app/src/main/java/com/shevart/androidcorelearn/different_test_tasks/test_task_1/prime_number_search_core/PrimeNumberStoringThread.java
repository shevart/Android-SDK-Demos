package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

class PrimeNumberStoringThread extends Thread {
    private PrimeNumberBuffer buffer;
    private PrimeNumbersCallback primeNumbersCallback;
    private boolean finish = false;

    public PrimeNumberStoringThread(@NonNull PrimeNumberBuffer buffer,
                                    @NonNull PrimeNumbersCallback callback) {
        this.buffer = buffer;
        primeNumbersCallback = callback;
    }

    private void finish() {
        finish = true;
    }

    @Override
    public void run() {
        while (!finish) {
            primeNumbersCallback.onNewPrimeNumberFound(buffer.getPrimeNumber());
        }
    }
}