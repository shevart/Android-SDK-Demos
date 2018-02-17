package com.shevart.androidcorelearn.common

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.utils.UiNotificationsUtils

// todo temp decision, review it
class AutoClosableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_closable)

        val handler = Handler(mainLooper)
        handler.postDelayed({ finish() }, DELAY)
    }

    override fun onBackPressed() {
        // super.onBackPressed();
        UiNotificationsUtils.showDevMessage(this,
                getString(R.string.wait_few_seconds_this_screen_will_be_automatically_closed))
    }

    companion object {
        private const val DELAY = (1000 * 3).toLong() // 3 secs
    }
}