package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;
import com.shevart.androidcorelearn.utils.LogUtil;

import java.util.ArrayDeque;
import java.util.Queue;

class PrimeNumberBridge {
    private Queue<PrimeNumber> primeNumbersQueue = new ArrayDeque<>();
    private int workersCount;

    PrimeNumberBridge(int workersCount) {
        this.workersCount = workersCount;
    }

    synchronized void addNewPrimeNumber(@NonNull PrimeNumber primeNumber) {
        primeNumbersQueue.add(primeNumber);
        notify();
    }

    void onWorkerFinish() {
        workersCount--;
        notify();
    }

    boolean isFinish() {
        return workersCount == 0;
    }

    synchronized PrimeNumber getPrimeNumber() {
        PrimeNumber result;
        while ((result = primeNumbersQueue.poll()) == null
                && workersCount > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                LogUtil.e(e);
                break;
            }
        }
        return result;
    }
}
