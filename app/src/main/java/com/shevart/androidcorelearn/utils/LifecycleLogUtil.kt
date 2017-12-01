package com.shevart.androidcorelearn.utils

import java.util.Locale

object LifecycleLogUtil {
    private val LOG_PATTERN = "<--%s-->: %s"

    fun logMessage(name: String, msg: String) {
        LogUtil.e(String.format(Locale.ENGLISH, LOG_PATTERN, name, msg))
    }
}