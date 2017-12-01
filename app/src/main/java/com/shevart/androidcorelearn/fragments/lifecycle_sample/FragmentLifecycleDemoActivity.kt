package com.shevart.androidcorelearn.fragments.lifecycle_sample

import android.app.Fragment
import android.os.Bundle

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.utils.FragmentUtil
import com.shevart.androidcorelearn.utils.LifecycleLogUtil
import com.shevart.androidcorelearn.utils.UiNotificationsUtils

class FragmentLifecycleDemoActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_lifecycle_demo)
        enableToolbarBackButton()

        UiNotificationsUtils.showToast(this, "See logs!")
        LifecycleLogUtil.logMessage(TAG, "onCreate()")
        FragmentUtil.addFragment(supportFragmentManager,
                LifecycleAddedDemoFragmentFragment(),
                R.id.flFragmentLifecycleContainer)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LifecycleLogUtil.logMessage(TAG, "onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        LifecycleLogUtil.logMessage(TAG, "onRestoreInstanceState()")
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        LifecycleLogUtil.logMessage(TAG, "onAttachFragment(), " + fragment.javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        LifecycleLogUtil.logMessage(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        LifecycleLogUtil.logMessage(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        LifecycleLogUtil.logMessage(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        LifecycleLogUtil.logMessage(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        LifecycleLogUtil.logMessage(TAG, "onDestroy()")
    }

    companion object {
        private val TAG = "Activity"
    }
}