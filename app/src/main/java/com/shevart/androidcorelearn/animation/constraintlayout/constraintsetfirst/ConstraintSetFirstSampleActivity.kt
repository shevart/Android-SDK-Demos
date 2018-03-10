package com.shevart.androidcorelearn.animation.constraintlayout.constraintsetfirst

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.view.View
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_onstraint_set_first_sample.*

class ConstraintSetFirstSampleActivity : AbsActivity() {

    private lateinit var constraintLayout: ConstraintLayout
    private var isLastDirectionToDown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onstraint_set_first_sample)
        enableToolbarBackButton()

        constraintLayout = clConstraintSetFirst

        btOne.setOnClickListener {
            upOrDownButtons()
        }

        btTwo.setOnClickListener {
            showButtonTwo()
        }

        btThree.setOnClickListener {
            hideButtonThree()
        }
    }

    private fun upOrDownButtons() {
        ConstraintSet().applyAnim(constraintLayout) {
            if (isLastDirectionToDown) {
                isLastDirectionToDown = false
                it.setVerticalBias(R.id.btOne, 0.2f)
            } else {
                isLastDirectionToDown = true
                it.setVerticalBias(R.id.btOne, 0.8f)
            }
        }
    }

    private fun showButtonTwo() {
        // todo demo of old code - remove after 1 year
//        val constraintSet = ConstraintSet()
//        constraintSet.clone(constraintLayout)
//
//        TransitionManager.beginDelayedTransition(constraintLayout)
//        constraintSet.setVisibility(R.id.btThree, View.VISIBLE)
//        constraintSet.applyTo(constraintLayout)

        ConstraintSet().applyAnim(constraintLayout) {
            it.setVisibility(R.id.btThree, View.VISIBLE)
        }
    }

    private fun hideButtonThree() {
        // todo demo of old code - remove after 1 year
//        val constraintSet = ConstraintSet()
//        constraintSet.clone(constraintLayout)
//
//        TransitionManager.beginDelayedTransition(constraintLayout)
//        constraintSet.setVisibility(R.id.btThree, View.GONE)
//        constraintSet.applyTo(constraintLayout)

        ConstraintSet().applyAnim(constraintLayout) {
            it.setVisibility(R.id.btThree, View.GONE)
        }
    }

    private inline fun ConstraintSet.applyAnim(constraintLayout: ConstraintLayout,
                                               action: (constraintSet: ConstraintSet)-> Unit) {
        this.clone(constraintLayout)
        TransitionManager.beginDelayedTransition(constraintLayout)
        action.invoke(this)
        this.applyTo(constraintLayout)
    }
}
