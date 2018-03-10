package com.shevart.androidcorelearn.animation

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_android_animations_topics_menu.*

class AndroidAnimationsTopicsMenuActivity : AbsActivity() {
    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btAnimationTransition -> Launcher.transitionAnimation(this)
            R.id.btAnimationConstraintLayout -> Launcher.constraintLayoutAnimation(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_animations_topics_menu)
        enableToolbarBackButton()

        btAnimationTransition.setOnClickListener(clickListener)
        btAnimationConstraintLayout.setOnClickListener(clickListener)
    }
}