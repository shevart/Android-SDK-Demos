package com.shevart.androidcorelearn.service

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.service.service_not_sticky.NotStickyService
import kotlinx.android.synthetic.main.activity_service_learn.*

class ServiceLearnActivity : AbsActivity() {
    private val serviceClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btStartNotStickyService -> startService(Intent(this@ServiceLearnActivity, NotStickyService::class.java))
            R.id.btStartBinderServiceScreen -> Launcher.binderServiceDemo(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_learn)
        enableToolbarBackButton()
        btStartNotStickyService.setOnClickListener(serviceClickListener)
        btStartBinderServiceScreen.setOnClickListener(serviceClickListener)
    }
}
