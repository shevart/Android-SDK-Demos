package com.shevart.androidcorelearn.arch_components.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler

import com.shevart.androidcorelearn.common.SimpleItem
import com.shevart.androidcorelearn.utils.LogUtil
import com.shevart.androidcorelearn.utils.MockUtils

class MyViewModel : ViewModel() {
    private var listLiveData: MutableLiveData<List<SimpleItem>>? = null

    @Synchronized internal fun getListLiveData(): LiveData<List<SimpleItem>> {
        if (listLiveData == null) {
            listLiveData = MutableLiveData()
            loadSimpleItemsList()
        }

        return listLiveData!!
    }

    private fun loadSimpleItemsList() {
        Handler().postDelayed({ listLiveData!!.value = MockUtils.SimpleItems.generateSimpleItemsList() }, 3000)
    }

    override fun onCleared() {
        super.onCleared()
        LogUtil.d("onCleared()")
    }
}