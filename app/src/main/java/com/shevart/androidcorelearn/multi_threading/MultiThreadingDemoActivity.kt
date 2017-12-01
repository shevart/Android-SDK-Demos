package com.shevart.androidcorelearn.multi_threading

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.multi_threading.executors.ExecutorsDemoActivity
import com.shevart.androidcorelearn.multi_threading.handler_looper.HandlerLooperSampleActivity
import com.shevart.androidcorelearn.multi_threading.simple_threads.SimpleThreadsSampleActivity
import kotlinx.android.synthetic.main.activity_multi_threading_demo.*

class MultiThreadingDemoActivity : AbsActivity() {
    private val buttonsClickListener = View.OnClickListener { v ->
        // todo use Launcher!
        when (v.id) {
            R.id.btSimpleThreads -> startActivity(Intent(this@MultiThreadingDemoActivity, SimpleThreadsSampleActivity::class.java))
            R.id.btHandlerLooper -> startActivity(Intent(this@MultiThreadingDemoActivity, HandlerLooperSampleActivity::class.java))
            R.id.btExecutors -> startActivity(Intent(this@MultiThreadingDemoActivity, ExecutorsDemoActivity::class.java))
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_threading_demo)
        enableToolbarBackButton()

        btSimpleThreads.setOnClickListener(buttonsClickListener)
        btHandlerLooper.setOnClickListener(buttonsClickListener)
        btExecutors.setOnClickListener(buttonsClickListener)
    }
}