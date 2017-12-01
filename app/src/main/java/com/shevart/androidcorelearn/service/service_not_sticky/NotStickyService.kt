package com.shevart.androidcorelearn.service.service_not_sticky

import android.app.Service
import android.content.Intent
import android.os.IBinder

import com.shevart.androidcorelearn.utils.LongRunningOperationsMockUtils
import com.shevart.androidcorelearn.utils.UiNotificationsUtils

class NotStickyService : Service() {

    override fun onCreate() {
        UiNotificationsUtils.showDevMessage(this, "onCreate()")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        UiNotificationsUtils.showDevMessage(this, "onStartCommand()")
        tellAboutFlags(flags)
        UiNotificationsUtils.showDevMessage(this, "startId: " + startId)
        longRunningTask()
        return Service.START_NOT_STICKY
    }

    private fun tellAboutFlags(flags: Int) {
        when (flags) {
            0 -> UiNotificationsUtils.showDevMessage(this, "flags is default value, 0")
            Service.START_FLAG_REDELIVERY -> UiNotificationsUtils.showDevMessage(this, "flags is START_FLAG_REDELIVERY")
            Service.START_FLAG_RETRY -> UiNotificationsUtils.showDevMessage(this, "flags is START_FLAG_RETRY")
            else -> throw IllegalArgumentException("Handle it! Flags is " + flags)
        }
    }

    private fun longRunningTask() {
        LongRunningOperationsMockUtils.mock_5_seconds_task(this)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        UiNotificationsUtils.showDevMessage(this, "onDestroy()")
    }
}
