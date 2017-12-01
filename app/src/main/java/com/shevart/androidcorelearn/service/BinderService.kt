package com.shevart.androidcorelearn.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

import com.shevart.androidcorelearn.utils.LogUtil

class BinderService : Service() {
    private val myBinder = MyBinder(this)

    override fun onBind(intent: Intent): IBinder? {
        LogUtil.e("BinderService: onBind()")
        return myBinder
    }

    override fun onUnbind(intent: Intent): Boolean {
        LogUtil.e("BinderService: onUnbind()")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        LogUtil.e("BinderService: onDestroy()")
        super.onDestroy()
    }

    fun forceManualStopService() {
        LogUtil.e("forceManualStopService()")
        stopSelf()
    }

    internal class MyBinder(val binderService: BinderService) : Binder()
}
