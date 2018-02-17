package com.shevart.androidcorelearn.view.customlayoutmanager

import android.os.Bundle
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.SimpleItem
import com.shevart.androidcorelearn.common.SimpleItemsRVAdapter
import com.shevart.androidcorelearn.utils.MockUtils
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import kotlinx.android.synthetic.main.activity_custom_layout_manager_demo.*

class CustomLayoutManagerDemoActivity : AbsActivity(), SimpleItemsRVAdapter.OnSimpleItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_manager_demo)
        enableToolbarBackButton()

        rvLayoutManagerDemo.layoutManager = SimpleCustomLayoutManager()
        rvLayoutManagerDemo.adapter = createAdapter()
    }

    private fun createAdapter() =
            SimpleItemsRVAdapter(this).apply {
                update(MockUtils.SimpleItems.generateSimpleItemsList())
                setUseDifferentBackgroundColors(true)
            }

    override fun onSimpleItemSelected(simpleItem: SimpleItem) {
        UiNotificationsUtils.showToast(this, simpleItem.toString())
    }
}
