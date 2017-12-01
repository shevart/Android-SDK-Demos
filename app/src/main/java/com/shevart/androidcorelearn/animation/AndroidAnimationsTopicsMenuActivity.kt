package com.shevart.androidcorelearn.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import kotlinx.android.synthetic.main.activity_android_animations_topics_menu.*

class AndroidAnimationsTopicsMenuActivity : AppCompatActivity() {
    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btAnimationTransition -> Launcher.transitionAnimation(this)
            else -> throw IllegalArgumentException("Handle it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_animations_topics_menu)

        btAnimationTransition.setOnClickListener(clickListener)
    }
}
