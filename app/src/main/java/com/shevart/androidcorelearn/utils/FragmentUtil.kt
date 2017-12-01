package com.shevart.androidcorelearn.utils

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

object FragmentUtil {
    /*
     * Common methods
     */
    @JvmOverloads
    fun replaceFragment(fragmentManager: FragmentManager,
                        fragment: Fragment,
                        @IdRes containerId: Int,
                        backStack: Boolean = false) {
        val fragmentTransaction = fragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
        if (backStack)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    @JvmOverloads
    fun addFragment(fragmentManager: FragmentManager,
                    fragment: Fragment,
                    @IdRes containerId: Int,
                    stackTrace: Boolean = false) {
        val fragmentTransaction = fragmentManager
                .beginTransaction()
                .add(containerId, fragment)
        if (stackTrace)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    @JvmOverloads
    fun removeFragment(fragmentManager: FragmentManager,
                       fragment: Fragment,
                       stackTrace: Boolean = false) {
        val fragmentTransaction = fragmentManager
                .beginTransaction()
                .remove(fragment)
        if (stackTrace)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}