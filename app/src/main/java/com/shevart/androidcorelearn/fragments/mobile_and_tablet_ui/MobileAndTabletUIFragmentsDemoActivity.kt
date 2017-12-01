package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui

import android.content.Intent
import android.os.Bundle

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.SimpleItem
import com.shevart.androidcorelearn.utils.FragmentUtil
import com.shevart.androidcorelearn.utils.MockUtils

import java.util.ArrayList

class MobileAndTabletUIFragmentsDemoActivity : AbsActivity() {
    private var fragmentList: ListScreenFragment? = null
    private var fragmentDetail: DetailScreenFragment? = null
    private val items = MockUtils.SimpleItems.generateSimpleItemsList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_and_tablet_uifragments_demo)
        enableToolbarBackButton()

        val isTablet = resources.getBoolean(R.bool.is_tablet)
        fragmentList = ListScreenFragment.getInstance(items)

        if (!isTablet) {
            FragmentUtil.replaceFragment(supportFragmentManager, fragmentList!!, R.id.flContainer)
        } else {
            fragmentDetail = DetailScreenFragment.getInstance(items[0])
            FragmentUtil.replaceFragment(supportFragmentManager, fragmentList!!, R.id.flList)
            FragmentUtil.replaceFragment(supportFragmentManager, fragmentDetail!!, R.id.flDetail)
        }
    }

    internal fun onItemSelected(item: SimpleItem) {
        if (fragmentDetail != null) {
            fragmentDetail!!.update(item)
        } else {
            // todo replace this logic to Launcher
            val intent = Intent(this, DetailScreenActivity::class.java)
            val args = Bundle()
            args.putParcelable(SimpleItem::class.java.simpleName, item)
            intent.putExtras(args)
            startActivity(intent)
        }
    }
}