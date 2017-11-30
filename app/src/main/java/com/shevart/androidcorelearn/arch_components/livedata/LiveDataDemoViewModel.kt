package com.shevart.androidcorelearn.arch_components.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler

class LiveDataDemoViewModel : ViewModel() {
    private var userNameLiveData: MutableLiveData<String>? = null

    fun getUserName() : LiveData<String> {
        if (userNameLiveData == null) {
            userNameLiveData = MutableLiveData()
            loadSimpleLiveData()
        }
        return userNameLiveData!!
    }

    private fun loadSimpleLiveData() {
        Handler().postDelayed({ userNameLiveData?.value = "Vasya" }, 1000)
    }
}