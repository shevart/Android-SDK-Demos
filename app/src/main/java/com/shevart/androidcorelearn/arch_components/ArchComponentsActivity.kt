package com.shevart.androidcorelearn.arch_components

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.arch_components.viewmodel.SimpleViewModelSampleActivity
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_arch_components.*

class ArchComponentsActivity : AbsActivity() {
    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btViewModelTopic -> startActivity(Intent(this, SimpleViewModelSampleActivity::class.java))
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arch_components)
        enableToolbarBackButton()

        btViewModelTopic.setOnClickListener(clickListener)
    }
}