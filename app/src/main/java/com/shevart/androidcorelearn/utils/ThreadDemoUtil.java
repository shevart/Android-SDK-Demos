package com.shevart.androidcorelearn.utils;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/***
 * <h3>Developer comment</h3>
 * This class make your code shorter, without unnecessary try-catch block for {@link InterruptedException}
 */
@SuppressWarnings("WeakerAccess")
public class ThreadDemoUtil {
    public static void sendEmptyTasksToExecutor5(@NonNull Executor executor) {
        sendEmptyTasksToExecutor(executor, 5);
    }

    public static void sendEmptyTasksToExecutor50(@NonNull Executor executor) {
        sendEmptyTasksToExecutor(executor, 50);
    }

    public static void sleep50ms() {
        sleep(50);
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
                sleep50ms();
                LogUtil.INSTANCE.e("TaskId: " + taskId + ", thread name is: " + Thread.currentThread().getName());
            }
        };
    }

    public static List<Callable<String>> createTestTasksList(int sizeOfTasks) {
        final List<Callable<String>> tasksList = new ArrayList<>();
        for (int i = 0; i < sizeOfTasks; i++) {
            tasksList.add(testCallable(i));
        }
        return tasksList;
    }

    private static Callable<String> testCallable(final int taskNumber) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task #" + taskNumber;
            }
        };
    }
}
