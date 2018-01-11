package com.shevart.androidcorelearn.view.customlayoutmanager

import android.os.Bundle
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity

class CustomLayoutManagerDemoActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_manager_demo)
        enableToolbarBackButton()
    }
}
