package com.shevart.androidcorelearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val launcherClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btServiceTopic -> Launcher.serviceTopic(this)
            R.id.btFragmentsTopic -> Launcher.fragmentsTopic(this)
            R.id.btMultiThreads -> Launcher.multiThreadingTopic(this)
            R.id.btArchComponents -> Launcher.archComponents(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btServiceTopic.setOnClickListener(launcherClickListener)
        btFragmentsTopic.setOnClickListener(launcherClickListener)
        btMultiThreads.setOnClickListener(launcherClickListener)
        btArchComponents.setOnClickListener(launcherClickListener)
    }
}
