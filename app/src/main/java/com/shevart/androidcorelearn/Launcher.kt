package com.shevart.androidcorelearn

import android.app.Activity
import android.content.Intent
import com.shevart.androidcorelearn.arch_components.ArchComponentsActivity
import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity

import com.shevart.androidcorelearn.service.ServiceLearnActivity

object Launcher {
    fun serviceTopic(activity: Activity) {
        activity.startActivity(Intent(activity, ServiceLearnActivity::class.java))
    }

    fun fragmentsTopic(activity: Activity) {
        activity.startActivity(Intent(activity, FragmentsDemoActivity::class.java))
    }

    fun multiThreadingTopic(activity: Activity) {
        activity.startActivity(Intent(activity, MultiThreadingDemoActivity::class.java))
    }

    fun archComponents(activity: Activity) {
        activity.startActivity(Intent(activity, ArchComponentsActivity::class.java))
    }
}
