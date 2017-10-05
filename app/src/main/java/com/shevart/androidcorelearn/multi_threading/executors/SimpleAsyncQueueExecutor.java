package com.shevart.androidcorelearn.multi_threading.executors;

import android.support.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class SimpleAsyncQueueExecutor implements Executor {
    private Queue<Runnable> queue = new ArrayDeque<>();
    private Runnable currentTask;

    @Override
    public synchronized void execute(@NonNull Runnable command) {
        queue.add(wrappNewTask(command));
        if (currentTask == null) {
            nextStep();
        }
    }

    private Runnable wrappNewTask(@NonNull final Runnable task) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } finally {
                    nextStep();
                }
            }
        };
    }

    private synchronized void nextStep() {
        if ((currentTask = queue.poll()) != null)
            executeTask(currentTask);
    }

    // in this method we can perform our task manually or with another Executor (or ThreadPoolExecutor)
    private void executeTask(@NonNull Runnable task) {
        new Thread(task).start();
    }
}