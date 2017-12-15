package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample

import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_handler_background_worker_sample.*
import java.util.*

class HandlerBackgroundWorkerSampleActivity : AbsActivity() {
    private lateinit var workerThread: WorkerThread
    private lateinit var uiHandler: Handler
    private var jobId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_background_worker_sample)
        enableToolbarBackButton()

        uiHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                if (msg.what == ON_JOB_COMPLETE_WHAT) {
                    tvRunningJobsStatus.text = String.format(Locale.ENGLISH, "%s%s %s",
                            "Job with id:", msg.arg1, " is complete!")
                } else {
                    super.handleMessage(msg)
                }
            }
        }

        workerThread = WorkerThread(uiHandler)
        workerThread.start()

        btRunJob.setOnClickListener { passToWorkerThreadSomeJob() }
    }

    private fun passToWorkerThreadSomeJob() {
        workerThread.runSomeJob(jobId++)
    }

    override fun onDestroy() {
        super.onDestroy()
        workerThread.stopWork()
    }

    companion object {
        internal val ON_JOB_COMPLETE_WHAT = 2
    }
}