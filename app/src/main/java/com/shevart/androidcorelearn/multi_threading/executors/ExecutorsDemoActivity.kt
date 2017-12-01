package com.shevart.androidcorelearn.multi_threading.executors

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.DemoStartable
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import kotlinx.android.synthetic.main.activity_executors_demo.*

class ExecutorsDemoActivity : AbsActivity() {
    private val asyncQueueExecutorDemo : DemoStartable = SimpleQueueExecutorDemo()
    private val fixedThreadPoolDemo : DemoStartable= FixedThreadPoolDemo()
    private val singleThreadExecutorDemo : DemoStartable= SingleThreadExecutorDemo()
    private val allExecutorServiceMethodsDemo : DemoStartable= AllExecutorServiceMethodsDemo()
    private val futureTaskDemo : DemoStartable = FutureTaskDemo()

    private val buttonsClickListener = View.OnClickListener { v ->
        UiNotificationsUtils.Extra.developerSeeToLogsMsg(this@ExecutorsDemoActivity)
        when (v.id) {
            R.id.btSimpleQueueExecutor -> asyncQueueExecutorDemo.startDemo()
            R.id.btFixedThreadPool -> fixedThreadPoolDemo.startDemo()
            R.id.btSingleThreadExecutor -> singleThreadExecutorDemo.startDemo()
            R.id.btAllExecutorServiceMethods -> allExecutorServiceMethodsDemo.startDemo()
            R.id.btFutureTask -> futureTaskDemo.startDemo()
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_executors_demo)
        enableToolbarBackButton()

        btSimpleQueueExecutor.setOnClickListener(buttonsClickListener)
        btFixedThreadPool.setOnClickListener(buttonsClickListener)
        btSingleThreadExecutor.setOnClickListener(buttonsClickListener)
        btAllExecutorServiceMethods.setOnClickListener(buttonsClickListener)
        btFutureTask.setOnClickListener(buttonsClickListener)
    }
}