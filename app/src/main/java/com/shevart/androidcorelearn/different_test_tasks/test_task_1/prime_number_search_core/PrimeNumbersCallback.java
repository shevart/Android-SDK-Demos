package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

public interface PrimeNumbersCallback {
    void onNewPrimeNumberFound(@NonNull PrimeNumber primeNumber);
}