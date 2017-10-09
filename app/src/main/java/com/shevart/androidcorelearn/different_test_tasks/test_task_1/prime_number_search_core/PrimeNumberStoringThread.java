package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.utils.LogUtil;

class PrimeNumberStoringThread extends Thread {
    private PrimeNumberBridge bridge;
    private PrimeNumbersCallback primeNumbersCallback;

    PrimeNumberStoringThread(@NonNull PrimeNumberBridge bridge,
                                    @NonNull PrimeNumbersCallback callback) {
        this.bridge = bridge;
        primeNumbersCallback = callback;
    }

    @Override
    public void run() {
        while (!bridge.isFinish()) {
            primeNumbersCallback.onNewPrimeNumberFound(bridge.getPrimeNumber());
        }
        LogUtil.e("PrimeNumberStoringThread - finish");
    }
}