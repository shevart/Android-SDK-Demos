package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui

import android.os.Bundle

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.SimpleItem

class DetailScreenActivity : AbsActivity() {

    private val simpleItemFromIntent: SimpleItem
        get() = intent.getParcelableExtra(SimpleItem::class.java.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        enableToolbarBackButton()

        val fragment = supportFragmentManager
                .findFragmentById(R.id.fragmentDetail) as DetailScreenFragment
        fragment.update(simpleItemFromIntent)
    }
}