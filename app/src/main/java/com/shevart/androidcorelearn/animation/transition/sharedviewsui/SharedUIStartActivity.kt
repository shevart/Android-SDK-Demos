package com.shevart.androidcorelearn.animation.transition.sharedviewsui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Pair
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_shared_uistart.*

class SharedUIStartActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_uistart)
        enableToolbarBackButton()

        tvSharedUISelect.setOnClickListener {
            openSecondScreen()
        }
    }

    private fun openSecondScreen() {
        val intent = Intent(this, SharedUIFinishActivity::class.java)
        // Pass data object in the bundle and populate details activity.
        val firstPair = Pair(cvSharedUI as View, getString(R.string.shared_ui_view))
        val secondPair = Pair(ivIconSharedUIStart as View, getString(R.string.shared_ui_icon))
        val thirdPair = Pair(tvSharedUISelect as View, getString(R.string.shared_ui_text))

        val options = ActivityOptions.makeSceneTransitionAnimation(this,
                        firstPair, secondPair, thirdPair)

        startActivity(intent, options.toBundle())
    }
}
