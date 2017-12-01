package com.shevart.androidcorelearn.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.fragments.back_stack_sample.FragmentsBackStackSampleActivity
import com.shevart.androidcorelearn.fragments.commits_samples.CommitsSampleHostActivity
import com.shevart.androidcorelearn.fragments.lifecycle_sample.FragmentLifecycleDemoActivity
import com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui.MobileAndTabletUIFragmentsDemoActivity
import com.shevart.androidcorelearn.fragments.transactions_samples.FragmentTransactionsActivity
import kotlinx.android.synthetic.main.activity_fragments_demo.*

class FragmentsDemoActivity : AbsActivity() {
    private val clickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btFragmentsLifecycle -> startActivity(Intent(this@FragmentsDemoActivity, FragmentLifecycleDemoActivity::class.java))
            R.id.btMobileAndTabletFragmentsUi -> startActivity(Intent(this@FragmentsDemoActivity, MobileAndTabletUIFragmentsDemoActivity::class.java))
            R.id.btCommitsSample -> startActivity(Intent(this@FragmentsDemoActivity, CommitsSampleHostActivity::class.java))
            R.id.btTransactionsSample -> startActivity(Intent(this@FragmentsDemoActivity, FragmentTransactionsActivity::class.java))
            R.id.btBackStackSample -> startActivity(Intent(this@FragmentsDemoActivity, FragmentsBackStackSampleActivity::class.java))
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_demo)
        enableToolbarBackButton()
        
        btFragmentsLifecycle.setOnClickListener(clickListener)
        btMobileAndTabletFragmentsUi.setOnClickListener(clickListener)
        btCommitsSample.setOnClickListener(clickListener)
        btTransactionsSample.setOnClickListener(clickListener)
        btBackStackSample.setOnClickListener(clickListener)
    }
}