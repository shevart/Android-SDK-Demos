package com.shevart.androidcorelearn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.shevart.androidcorelearn.arch_components.ArchComponentsActivity
import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity
import com.shevart.androidcorelearn.service.ServiceLearnActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val launcherClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btServiceTopic -> startActivity(Intent(this@MainActivity, ServiceLearnActivity::class.java))
            R.id.btFragmentsTopic -> startActivity(Intent(this@MainActivity, FragmentsDemoActivity::class.java))
            R.id.btMultiThreads -> startActivity(Intent(this@MainActivity, MultiThreadingDemoActivity::class.java))
            R.id.btArchComponents -> startActivity(Intent(this@MainActivity, ArchComponentsActivity::class.java))
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

        // TODO: 09.10.17 remove after test
        //        startActivity(new Intent(this, TestTask1Activity.class));
    }
}
