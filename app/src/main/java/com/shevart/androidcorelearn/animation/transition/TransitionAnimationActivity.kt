package com.shevart.androidcorelearn.animation.transition

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_transition_animation.*

class TransitionAnimationActivity : AbsActivity() {
    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btScreenSharedElements -> Launcher.sharedElementsAnimation(this)
            R.id.btScreenSharedUI -> Launcher.sharedUIElementsAnimation(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_animation)
        enableToolbarBackButton()

        btScreenSharedElements.setOnClickListener(clickListener)
        btScreenSharedUI.setOnClickListener(clickListener)
    }
}
