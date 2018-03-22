package com.shevart.androidcorelearn.animation.transition.layoutchanges

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_layout_change_transition.*
import java.util.*

class LayoutChangeTransitionActivity : AbsActivity() {
    private val random = Random()
    private var oneDpInPixels = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_change_transition)
        enableToolbarBackButton()

        // review it, temp solution
        flTestContent.postDelayed({
            oneDpInPixels = flTestContent.height / 100
        }, 100)

        cvLayoutChangesAnim.setOnClickListener {
            flTestContent.visibility = View.INVISIBLE
            TransitionManager.beginDelayedTransition(cvLayoutChangesAnim)
            flTestContent.layoutParams = flTestContent.layoutParams.apply {
                height = oneDpInPixels * (50 + random.nextInt(250))
            }
            showWithAlpha()
        }
    }

    // review it, temp solution
    private fun showWithAlpha() {
        flTestContent.postDelayed({
            TransitionManager.beginDelayedTransition(cvLayoutChangesAnim)
            flTestContent.visibility = View.VISIBLE
        }, 500)
    }
}
