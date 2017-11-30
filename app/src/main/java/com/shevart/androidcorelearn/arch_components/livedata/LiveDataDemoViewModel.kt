package com.shevart.androidcorelearn.arch_components.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.os.Looper
import com.shevart.androidcorelearn.common.SimpleItem
import com.shevart.androidcorelearn.utils.MockUtils

class LiveDataDemoViewModel : ViewModel() {
    private var userNameLiveData: MutableLiveData<String>? = null
    private var userMessagesLiveData: MediatorLiveData<SimpleItem>? = null

    fun getUserName() : LiveData<String> {
        if (userNameLiveData == null) {
            userNameLiveData = MutableLiveData()
            loadSimpleLiveData()
        }
        return userNameLiveData!!
    }

    fun getUserMessages() : LiveData<SimpleItem> {
        if (userMessagesLiveData == null) {
            userMessagesLiveData = MediatorLiveData()
            loadUserMessages()
        }
        return userMessagesLiveData!!
    }

    private fun loadSimpleLiveData() {
        Handler().postDelayed({ userNameLiveData?.value = "Vasya" }, 1000)
    }

    private fun loadUserMessages() {
        val handler = Handler(Looper.getMainLooper())
        val firstDataSource = MutableLiveData<SimpleItem>()
        val secondDataSource = MutableLiveData<SimpleItem>()

        userMessagesLiveData!!.addSource(firstDataSource, {userMessagesLiveData!!.postValue(it)})
        userMessagesLiveData!!.addSource(secondDataSource, {userMessagesLiveData!!.postValue(it)})

        var timeShift = 0L
        for (i in 1..10) {
            timeShift += 1_000
            handler.postDelayed({firstDataSource.value = MockUtils.SimpleItems.generateSimpleItem()}, timeShift)
            timeShift += 1_000
            handler.postDelayed({secondDataSource.value = MockUtils.SimpleItems.generateSimpleItem()}, timeShift)
        }
    }
}