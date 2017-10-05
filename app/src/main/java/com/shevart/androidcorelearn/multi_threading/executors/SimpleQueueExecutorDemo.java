package com.shevart.androidcorelearn.multi_threading.executors;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;

class SimpleQueueExecutorDemo implements DemoStartable {
    private SimpleAsyncQueueExecutor simpleAsyncQueueExecutor;

    @Override
    public void startDemo() {
        if (simpleAsyncQueueExecutor == null) {
            simpleAsyncQueueExecutor = new SimpleAsyncQueueExecutor();
        }

        for (int i = 0; i < 5; i++) {
            simpleAsyncQueueExecutor.execute(nextTask(i));
        }
    }

    private static Runnable nextTask(final int taskId) {
        return new Runnable() {
            @Override
            public void run() {
                LogUtil.e("TaskId: " + taskId);
            }
        };
    }
}