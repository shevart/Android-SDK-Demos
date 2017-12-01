package com.shevart.androidcorelearn

import android.app.Activity
import android.content.Intent
import com.shevart.androidcorelearn.animation.AndroidAnimationsTopicsMenuActivity
import com.shevart.androidcorelearn.animation.transition.TransitionAnimationActivity
import com.shevart.androidcorelearn.animation.transition.sharedviews.SharedViewsStartActivity
import com.shevart.androidcorelearn.arch_components.ArchComponentsActivity
import com.shevart.androidcorelearn.arch_components.livedata.LiveDataDemoActivity
import com.shevart.androidcorelearn.arch_components.viewmodel.SimpleViewModelSampleActivity
import com.shevart.androidcorelearn.common.AutoClosableActivity
import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity
import com.shevart.androidcorelearn.service.BinderServiceActivity

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

    fun liveDataDemo(activity: Activity) {
        startActivity(activity, LiveDataDemoActivity::class.java)
    }

    fun binderServiceDemo(activity: Activity) {
        startActivity(activity, BinderServiceActivity::class.java)
    }

    fun autoClosableScreen(activity: Activity) {
        startActivity(activity, AutoClosableActivity::class.java)
    }

    fun animationTopic(activity: Activity) {
        startActivity(activity, AndroidAnimationsTopicsMenuActivity::class.java)
    }

    fun transitionAnimation(activity: Activity) {
        startActivity(activity, TransitionAnimationActivity::class.java)
    }

    fun sharedElementsAnimation(activity: Activity) {
        startActivity(activity, SharedViewsStartActivity::class.java)
    }

    private fun startActivity(activity: Activity, clazz: Class<out Activity>) {
        activity.startActivity(Intent(activity, clazz))
    }
}
