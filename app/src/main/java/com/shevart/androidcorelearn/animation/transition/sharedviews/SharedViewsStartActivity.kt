package com.shevart.androidcorelearn.animation.transition.sharedviews

import android.os.Bundle
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity

class SharedViewsStartActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_views_start)
        enableToolbarBackButton()
    }
}
