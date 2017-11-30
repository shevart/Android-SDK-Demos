package com.shevart.androidcorelearn.arch_components.livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shevart.androidcorelearn.R
import kotlinx.android.synthetic.main.activity_live_data_demo.*

class LiveDataDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_demo)

        val viewModel = ViewModelProviders.of(this).get(LiveDataDemoViewModel::class.java)
        viewModel.getUserName().observe(this, Observer { tvUserName.text = it })
    }
}
