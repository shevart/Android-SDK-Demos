package com.shevart.androidcorelearn.multi_threading.handler_looper

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_handler_looper_sample.*

class HandlerLooperSampleActivity : AbsActivity() {
    private val buttonsClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btSimpleHandlerSample -> Launcher.simpleHandlerSample(this)
            R.id.btDelayedMessagesSample -> Launcher.handlerDelayedMessage(this)
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_looper_sample)
        enableToolbarBackButton()

        btSimpleHandlerSample.setOnClickListener(buttonsClickListener)
        btDelayedMessagesSample.setOnClickListener(buttonsClickListener)
    }
}