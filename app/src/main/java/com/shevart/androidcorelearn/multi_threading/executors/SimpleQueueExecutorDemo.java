package com.shevart.androidcorelearn.multi_threading.executors;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

class SimpleQueueExecutorDemo implements DemoStartable {
    private SimpleAsyncQueueExecutor simpleAsyncQueueExecutor;

    @Override
    public void startDemo() {
        if (simpleAsyncQueueExecutor == null) {
            simpleAsyncQueueExecutor = new SimpleAsyncQueueExecutor();
        }

        ThreadDemoUtil.sendEmptyTasksToExecutor5(simpleAsyncQueueExecutor);
    }
}