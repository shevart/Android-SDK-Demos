package com.shevart.androidcorelearn.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View


import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.utils.LogUtil
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import kotlinx.android.synthetic.main.activity_binder_service.*

class BinderServiceActivity : AbsActivity() {
    private var myBinder: BinderService.MyBinder? = null
    private var myConnection: ServiceConnection? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binder_service)
        enableToolbarBackButton()

        rbUnbounded.isChecked = true

        btBinderServiceBoundUnboud.setOnClickListener {
            if (myConnection != null) {
                unbindFromService()
            } else {
                bindToService()
            }
        }

        btForceDestroyBoundService.setOnClickListener {
            if (myBinder != null)
                myBinder?.binderService?.forceManualStopService()
        }
    }

    private fun bindToService() {
        UiNotificationsUtils.showDevMessage(this, "bindService()")
        myConnection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                myBinder = service as BinderService.MyBinder
                onConnected()
            }

            override fun onServiceDisconnected(name: ComponentName) {
                UiNotificationsUtils.showDevMessage(this@BinderServiceActivity, "onServiceDisconnected() ")
                LogUtil.e(name.className)
                myBinder = null
                onDisconnected()
            }
        }

        bindService(Intent(this, BinderService::class.java), myConnection, Context.BIND_AUTO_CREATE)
    }

    private fun unbindFromService() {
        UiNotificationsUtils.showDevMessage(this, "unbindFromService()")
        unbindService(myConnection)
        myBinder = null
        myConnection = null
        rbUnbounded.isChecked = true
    }

    override fun onStop() {
        super.onStop()
        if (myConnection != null)
            unbindFromService()
    }

    private fun onConnected() {
        UiNotificationsUtils.showDevMessage(this, "onConnected()")
        rbBounded.isChecked = true
    }

    private fun onDisconnected() {
        UiNotificationsUtils.showDevMessage(this, "onDisconnected()")
        rbUnbounded.isChecked = true
        myConnection = null
    }
}
