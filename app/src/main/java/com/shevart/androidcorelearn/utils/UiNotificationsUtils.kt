package com.shevart.androidcorelearn.utils

import android.content.Context
import android.widget.Toast

object UiNotificationsUtils {
    private val debug = true

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showDevMessage(context: Context, msg: String) {
        if (debug) {
            showToast(context, msg)
            LogUtil.e(msg)
        }
    }

    object Extra {
        fun developerSeeToLogsMsg(context: Context) {
            showDevMessage(context, "Developer, go to logs!")
        }
    }
}
