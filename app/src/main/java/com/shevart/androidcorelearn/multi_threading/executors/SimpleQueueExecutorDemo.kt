package com.shevart.androidcorelearn.multi_threading.executors

import com.shevart.androidcorelearn.common.DemoStartable
import com.shevart.androidcorelearn.utils.ThreadDemoUtil

internal class SimpleQueueExecutorDemo : DemoStartable {
    private var simpleAsyncQueueExecutor: SimpleAsyncQueueExecutor? = null

    override fun startDemo() {
        if (simpleAsyncQueueExecutor == null) {
            simpleAsyncQueueExecutor = SimpleAsyncQueueExecutor()
        }

        ThreadDemoUtil.sendEmptyTasksToExecutor5(simpleAsyncQueueExecutor!!)
    }
}