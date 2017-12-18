package com.shevart.androidcorelearn.animation.transition.sharedviews

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_shared_views_start.*

class SharedViewsStartActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_views_start)
        enableToolbarBackButton()

        btOpenDetail.setOnClickListener { openDetailScreen() }
    }

    private fun openDetailScreen() {
        val intent = Intent(this, SharedViewsFinishActivity::class.java)
        // Pass data object in the bundle and populate details activity.
        val options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, ivSmallAvatar, getString(R.string.avatar_transition))
        startActivity(intent, options.toBundle())
    }
}