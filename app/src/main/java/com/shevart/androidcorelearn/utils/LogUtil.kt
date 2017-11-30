package com.shevart.androidcorelearn.utils

import android.util.Log

object LogUtil {
    private val TAG = "<-- CoreLearnTag -->"

    fun e(e: String) {
        Log.e(TAG, e)
    }

    fun empty() {
        Log.e(TAG, "")
    }

    fun e(e: Throwable) {
        e.printStackTrace()
    }

    fun d(e: String) {
        Log.d(TAG, e)
    }
}
