package com.shevart.androidcorelearn.arch_components.viewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.SimpleItem
import com.shevart.androidcorelearn.common.SimpleItemsRVAdapter
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import kotlinx.android.synthetic.main.activity_simple_view_model_sample.*
import java.util.*

class SimpleViewModelSampleActivity : AbsActivity(), SimpleItemsRVAdapter.OnSimpleItemSelectedListener {
    private var adapter: SimpleItemsRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_view_model_sample)
        enableToolbarBackButton()

        initViews()
        showLoading()

        val viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.getListLiveData().observe(this, Observer { simpleItems -> onSimpleItemsLoaded(simpleItems, adapter) })
    }

    private fun initViews() {
        adapter = SimpleItemsRVAdapter(this, ArrayList())
        rvViewModelSample.layoutManager = LinearLayoutManager(this)
        rvViewModelSample.adapter = adapter
    }

    private fun onSimpleItemsLoaded(simpleItems: List<SimpleItem>?, adapter: SimpleItemsRVAdapter?) {
        if (simpleItems != null) {
            adapter?.update(simpleItems)
            showContent()
        }
    }


    override fun onSimpleItemSelected(simpleItem: SimpleItem) {
        UiNotificationsUtils.showToast(this, simpleItem.title)
    }

    private fun showLoading() {
        pbViewModelSampleLoading.visibility = View.VISIBLE
        rvViewModelSample.visibility = View.GONE
    }

    private fun showContent() {
        pbViewModelSampleLoading.visibility = View.GONE
        rvViewModelSample.visibility = View.VISIBLE
    }
}