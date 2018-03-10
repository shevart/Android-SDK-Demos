package com.shevart.androidcorelearn.animation.constraintlayout

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_constraint_layout_animation_topic.*

class ConstraintLayoutAnimationTopicActivity : AbsActivity() {
    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btCLAnimationConstraintSet -> Launcher.transitionSetFirstSample(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout_animation_topic)
        enableToolbarBackButton()

        btCLAnimationConstraintSet.setOnClickListener(clickListener)
    }
}
