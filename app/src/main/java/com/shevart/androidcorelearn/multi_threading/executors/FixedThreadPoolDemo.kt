package com.shevart.androidcorelearn.multi_threading.executors

import com.shevart.androidcorelearn.common.DemoStartable
import com.shevart.androidcorelearn.utils.ThreadDemoUtil

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

internal class FixedThreadPoolDemo : DemoStartable {
    override fun startDemo() {
        val executorService = Executors.newFixedThreadPool(4)
        ThreadDemoUtil.sendEmptyTasksToExecutor50(executorService)
        executorService.shutdown()
    }
}