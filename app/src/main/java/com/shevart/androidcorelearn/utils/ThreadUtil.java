package com.shevart.androidcorelearn.utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/***
 * <h3>Developer comment</h3>
 * This class make your code shorter, without unnecessary try-catch block for {@link InterruptedException}
 */
public class ThreadUtil {
    public static void sendEmptyTasksToExecutor5(@NonNull Executor executor) {
        sendEmptyTasksToExecutor(executor, 5);
    }

    public static void sleep500ms() {
        sleep(500);
    }

    public static void sleep1000ms() {
        sleep(1000);
    }

    public static void sleep2000ms() {
        sleep(2000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendEmptyTasksToExecutor(@NonNull Executor executor, int countOfTasks) {
        for (int i = 0; i < countOfTasks; i++) {
            executor.execute(nextEmptyTask(i));
        }
    }

    private static Runnable nextEmptyTask(final int taskId) {
        return new Runnable() {
            @Override
            public void run() {
                LogUtil.e("TaskId: " + taskId);
            }
        };
    }
}
