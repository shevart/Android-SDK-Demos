package com.shevart.androidcorelearn.utils

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

object UiUtil {
    fun inflate(parent: ViewGroup, @LayoutRes layoutRes: Int): View {
        return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
    }
}
