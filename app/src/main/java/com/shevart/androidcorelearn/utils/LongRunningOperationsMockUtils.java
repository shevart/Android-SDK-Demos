package com.shevart.androidcorelearn.utils;

import android.app.Service;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

public class LongRunningOperationsMockUtils {
    private static final long SLEEP_TIME_5_SEC = 5000;

    public static void mock_5_seconds_task(@NonNull final Service service) {
        startMockTask(service, SLEEP_TIME_5_SEC);
    }

    private static void startMockTask(@NonNull Service service, final long mockTaskTime) {
        final MockTask mockTask = new MockTask(service, mockTaskTime);
        mockTask.start();
    }

    private static class MockTask extends Thread {
        private long timeForSleepMilliseconds;
        private WeakReference<Service> serviceWeakReference;

        MockTask(@NonNull Service service, long sleepTime) {
            timeForSleepMilliseconds = sleepTime;
            serviceWeakReference = new WeakReference<>(service);
        }

        @Override
        public void run() {
            try {
                sleep(timeForSleepMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (serviceWeakReference.get() != null) {
                    serviceWeakReference.get().stopSelf();
                }
            }
        }
    }
}
