package com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@SuppressWarnings("WeakerAccess")
class PrimeNumberStoringThread extends Thread {
    public static final int NEW = 0;
    public static final int READY_FOR_WORK = 1;
    public static final int CONNECTED = 2;
    public static final int DISCONNECTED = 3;
    public static final int FINISHED = 4;

    @SuppressWarnings("WeakerAccess")
    @Retention(SOURCE)
    @IntDef({NEW, READY_FOR_WORK, CONNECTED, DISCONNECTED, FINISHED})
    public @interface StoringThreadState {
    }

    private PrimeNumberBridge bridge;
    private PrimeNumbersCallback primeNumbersCallback;
    @StoringThreadState
    private int state = NEW;

    PrimeNumberStoringThread(@NonNull PrimeNumberBridge bridge,
                                    @NonNull PrimeNumbersCallback callback) {
        this.bridge = bridge;
        primeNumbersCallback = callback;
    }

    @StoringThreadState
    public int getStoringThreadState() {
        return state;
    }

    public void finish() {
        state = FINISHED;
        interrupt();
    }

    @Override
    public void run() {
        while (state != FINISHED) {
            runByState();
        }
    }

    private void runByState() {
        switch (state) {
            case NEW:
                state = READY_FOR_WORK;
                break;
            case READY_FOR_WORK:
                state = CONNECTED;
                break;
            case CONNECTED:
                fetchPrimeNumber();
                break;
            case DISCONNECTED:
                handleDisconnect();
                break;
            case FINISHED:
                LogUtil.e("PrimeNumberStoringThread - finish");
                break;
        }
    }

    private void fetchPrimeNumber() {
        PrimeNumber primeNumber = bridge.getPrimeNumber();
        if (primeNumber != null) {
            ThreadDemoUtil.sleep500ms(); // fake delay
            primeNumbersCallback.onNewPrimeNumberFound(primeNumber);
        } else {
            handleError();
        }
    }

    private void handleError() {
        if (isInterrupted()) {
            state = FINISHED;
        } else if (bridge.isFinish()) {
            state = FINISHED;
        } else {
            state = DISCONNECTED;
        }
    }

    private void handleDisconnect() {
        state = FINISHED; // add your logic for handling disconnect
    }
}