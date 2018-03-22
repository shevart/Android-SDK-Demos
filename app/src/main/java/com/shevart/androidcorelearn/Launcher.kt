package com.shevart.androidcorelearn

import android.app.Activity
import android.content.Intent
import com.shevart.androidcorelearn.Launcher.startActivity
import com.shevart.androidcorelearn.animation.AndroidAnimationsTopicsMenuActivity
import com.shevart.androidcorelearn.animation.constraintlayout.ConstraintLayoutAnimationTopicActivity
import com.shevart.androidcorelearn.animation.constraintlayout.constraintsetfirst.ConstraintSetFirstSampleActivity
import com.shevart.androidcorelearn.animation.transition.TransitionAnimationActivity
import com.shevart.androidcorelearn.animation.transition.layoutchanges.LayoutChangeTransitionActivity
import com.shevart.androidcorelearn.animation.transition.scene.SceneDemoActivity
import com.shevart.androidcorelearn.animation.transition.sharedviews.SharedViewsStartActivity
import com.shevart.androidcorelearn.animation.transition.sharedviewsui.SharedUIStartActivity
import com.shevart.androidcorelearn.arch_components.ArchComponentsActivity
import com.shevart.androidcorelearn.arch_components.livedata.LiveDataDemoActivity
import com.shevart.androidcorelearn.arch_components.viewmodel.SimpleViewModelSampleActivity
import com.shevart.androidcorelearn.common.AutoClosableActivity
import com.shevart.androidcorelearn.fragments.FragmentsDemoActivity
import com.shevart.androidcorelearn.multi_threading.MultiThreadingDemoActivity
import com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample.HandlerBackgroundWorkerSampleActivity
import com.shevart.androidcorelearn.multi_threading.handler_looper.handler_delayed_messages.HandlerDelayedActivity
import com.shevart.androidcorelearn.service.BinderServiceActivity

import com.shevart.androidcorelearn.service.ServiceLearnActivity
import com.shevart.androidcorelearn.view.ViewsTopicActivity
import com.shevart.androidcorelearn.view.customlayoutmanager.CustomLayoutManagerDemoActivity

object Launcher {
    fun serviceTopic(activity: Activity) {
        startActivity<ServiceLearnActivity>(activity)
    }

    fun fragmentsTopic(activity: Activity) {
        startActivity<FragmentsDemoActivity>(activity)
    }

    fun multiThreadingTopic(activity: Activity) {
        startActivityOld(activity, MultiThreadingDemoActivity::class.java)
    }

    fun archComponents(activity: Activity) {
        startActivityOld(activity, ArchComponentsActivity::class.java)
    }

    fun viewModelSimpleDemo(activity: Activity) {
        startActivity<SimpleViewModelSampleActivity>(activity)
    }

    fun liveDataDemo(activity: Activity) {
        startActivity<LiveDataDemoActivity>(activity)
    }

    fun binderServiceDemo(activity: Activity) {
        startActivityOld(activity, BinderServiceActivity::class.java)
    }

    fun autoClosableScreen(activity: Activity) {
        startActivityOld(activity, AutoClosableActivity::class.java)
    }

    fun animationTopic(activity: Activity) {
        startActivityOld(activity, AndroidAnimationsTopicsMenuActivity::class.java)
    }

    fun viewTopic(activity: Activity) {
        startActivityOld(activity, ViewsTopicActivity::class.java)
    }

    fun transitionAnimation(activity: Activity) {
        startActivityOld(activity, TransitionAnimationActivity::class.java)
    }

    fun constraintLayoutAnimation(activity: Activity) {
        startActivity<ConstraintLayoutAnimationTopicActivity>(activity)
    }

    fun transitionSetFirstSample(activity: Activity) {
        startActivity<ConstraintSetFirstSampleActivity>(activity)
    }

    fun sharedElementsAnimation(activity: Activity) {
        startActivity<SharedViewsStartActivity>(activity)
    }

    fun sharedUIElementsAnimation(activity: Activity) {
        startActivity<SharedUIStartActivity>(activity)
    }

    fun simpleHandlerSample(activity: Activity) {
        startActivity<HandlerBackgroundWorkerSampleActivity>(activity)
    }

    fun handlerDelayedMessage(activity: Activity) {
        startActivity<HandlerDelayedActivity>(activity)
    }

    fun customLayoutManager(activity: Activity) {
        startActivity<CustomLayoutManagerDemoActivity>(activity)
    }

    fun layoutChangesAnim(activity: Activity) {
        startActivity<LayoutChangeTransitionActivity>(activity)
    }

    fun sceneDemo(activity: Activity) {
        startActivity<SceneDemoActivity>(activity)
    }

    @Deprecated("Use new version!", ReplaceWith("startActivity<clazz>(activity)"))
    private fun startActivityOld(activity: Activity, clazz: Class<out Activity>) {
        activity.startActivity(Intent(activity, clazz))
    }

    private inline fun <reified T: Activity> startActivity(activity: Activity) {
        activity.startActivity(Intent(activity, T::class.java))
    }
}
