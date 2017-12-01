package com.shevart.androidcorelearn.animation.transition.sharedviews

import android.os.Bundle
import android.view.MenuItem
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity

class SharedViewsFinishActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_views_finish)
        enableToolbarBackButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            supportFinishAfterTransition()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
