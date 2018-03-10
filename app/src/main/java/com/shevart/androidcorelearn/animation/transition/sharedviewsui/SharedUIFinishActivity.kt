package com.shevart.androidcorelearn.animation.transition.sharedviewsui

import android.os.Bundle
import android.view.MenuItem
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_shared_uifinish.*


class SharedUIFinishActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_uifinish)
        hideToolbar()

        ivCloseSharedUi.setOnClickListener {
            supportFinishAfterTransition()
        }
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
