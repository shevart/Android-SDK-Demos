package com.shevart.androidcorelearn.view

import android.os.Bundle
import android.view.View
import com.shevart.androidcorelearn.Launcher
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_views_topc.*

class ViewsTopicActivity : AbsActivity() {
    @Suppress("WhenWithOnlyElse")
    private val clickListener = View.OnClickListener { v ->
        when(v.id) {
            R.id.btCustomLayoutManager -> Launcher.customLayoutManager(this)
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views_topc)
        enableToolbarBackButton()

        btCustomLayoutManager.setOnClickListener(clickListener)
    }
}
