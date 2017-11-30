package com.shevart.androidcorelearn

import android.app.Activity
import android.content.Intent
import com.shevart.androidcorelearn.arch_components.ArchComponentsActivity
import com.shevart.androidcorelearn.arch_components.viewmodel.SimpleViewModelSampleActivity
import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity

import com.shevart.androidcorelearn.service.ServiceLearnActivity

object Launcher {
    fun serviceTopic(activity: Activity) {
        startActivity(activity, ServiceLearnActivity::class.java)
    }

    fun fragmentsTopic(activity: Activity) {
        startActivity(activity, FragmentsDemoActivity::class.java)
    }

    fun multiThreadingTopic(activity: Activity) {
        startActivity(activity, MultiThreadingDemoActivity::class.java)
    }

    fun archComponents(activity: Activity) {
        startActivity(activity, ArchComponentsActivity::class.java)
    }

    fun viewModelSimpleDemo(activity: Activity) {
        startActivity(activity, SimpleViewModelSampleActivity::class.java)
    }

    private fun startActivity(activity: Activity, clazz: Class<out Activity>) {
        activity.startActivity(Intent(activity, clazz))
    }
}
