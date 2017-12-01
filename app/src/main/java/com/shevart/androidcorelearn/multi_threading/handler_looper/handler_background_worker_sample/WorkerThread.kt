package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample

import android.os.Handler
import android.os.Looper
import android.os.Message

import com.shevart.androidcorelearn.utils.ThreadDemoUtil

/***
 * <h3>Developer comment</h3>
 * This thread is simple background worker for running long-running operations outside main thread.
 * There are two [Handler]'s - one for handling jobs in background thread and one for passing
 * results to main thread.
 */
internal class WorkerThread(private val responseHandler: Handler) : Thread() {
    private var workerHandler: Handler? = null

    override fun run() {
        // add looper and MessageQueue for this thread
        Looper.prepare()
        //prepare handler for work
        workerHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    SOME_JOB_WHAT -> runJob(msg.arg1)
                    else -> super.handleMessage(msg)
                }
            }
        }
        // start loop
        Looper.loop()
    }

    fun runSomeJob(jobId: Int) {
        val message = workerHandler!!.obtainMessage(SOME_JOB_WHAT, jobId, 0)
        workerHandler!!.sendMessage(message)
    }

    fun stopWork() {
        workerHandler!!.looper.quit()
    }

    // fake long-running operation
    private fun runJob(jobId: Int) {
        ThreadDemoUtil.sleep1000ms()
        onJobComplete(jobId)
    }

    // deliver result back to UI
    private fun onJobComplete(jobId: Int) {
        val message = responseHandler.obtainMessage(
                HandlerBackgroundWorkerSampleActivity.ON_JOB_COMPLETE_WHAT, jobId, 0)
        responseHandler.sendMessage(message)
    }

    companion object {
        private val SOME_JOB_WHAT = 1
    }
}