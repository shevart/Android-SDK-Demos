package com.shevart.androidcorelearn.fragments.lifecycle_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shevart.androidcorelearn.R

class LifecycleXMLInflatedDemoFragment : BaseLifecycleLogsFragment() {
    init {
        // Required empty public constructor
        logMessage("public constructor")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_lifecycle_demo, container, false)
    }

    override fun provideFragmentName(): String {
        return TAG
    }

    companion object {
        private val TAG = "FromXML"
    }
}