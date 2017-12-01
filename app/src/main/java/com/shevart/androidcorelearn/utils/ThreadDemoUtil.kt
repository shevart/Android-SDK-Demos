package com.shevart.androidcorelearn.utils

import java.util.ArrayList
import java.util.concurrent.Callable
import java.util.concurrent.Executor

@Suppress("MemberVisibilityCanPrivate")
/***
 * <h3>Developer comment</h3>
 * This class make your code shorter, without unnecessary try-catch block for [InterruptedException]
 */
object ThreadDemoUtil {
    fun sendEmptyTasksToExecutor5(executor: Executor) {
        sendEmptyTasksToExecutor(executor, 5)
    }

    fun sendEmptyTasksToExecutor50(executor: Executor) {
        sendEmptyTasksToExecutor(executor, 50)
    }

    fun sleep50ms() {
        sleep(50)
    }

    fun sleep500ms() {
        sleep(500)
    }

    fun sleep1000ms() {
        sleep(1000)
    }

    fun sleep2000ms() {
        sleep(2000)
    }

    private fun sleep(ms: Long) {
        try {
            Thread.sleep(ms)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun sendEmptyTasksToExecutor(executor: Executor, countOfTasks: Int) {
        for (i in 0 until countOfTasks) {
            executor.execute(nextEmptyTask(i))
        }
    }

    private fun nextEmptyTask(taskId: Int): Runnable {
        return Runnable {
            sleep50ms()
            LogUtil.e("TaskId: " + taskId + ", thread name is: " + Thread.currentThread().name)
        }
    }

    fun createTestTasksList(sizeOfTasks: Int): List<Callable<String>> {
        val tasksList = ArrayList<Callable<String>>()
        for (i in 0 until sizeOfTasks) {
            tasksList.add(testCallable(i))
        }
        return tasksList
    }

    private fun testCallable(taskNumber: Int): Callable<String> {
        return Callable { "Task #" + taskNumber }
    }
}
