package com.shevart.androidcorelearn.fragments.transactions_samples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.utils.FragmentUtil
import com.shevart.androidcorelearn.utils.LogUtil
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import com.shevart.androidcorelearn.utils.UiScreenMockUtils
import kotlinx.android.synthetic.main.activity_fragment_transactions.*
import kotlinx.android.synthetic.main.element_fragment_transaction_control_panel.*

import java.util.ArrayDeque
import java.util.Locale
import java.util.Queue

class FragmentTransactionsActivity : AbsActivity() {
    private val fragmentQueue = ArrayDeque<Fragment>()
    private val buttonsClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btAdd -> add(nextFragment(), cbAddToBackStack.isChecked)
            R.id.btReplace -> replace(nextFragment(), cbAddToBackStack.isChecked)
            R.id.btRemove -> remove(fragmentQueue.poll(), cbAddToBackStack.isChecked)
            else -> throw RuntimeException("Check it!")
        }
    }

    private fun nextFragment(): Fragment {
        val fragment = UiScreenMockUtils.nextDetailSimpleItemFragment()
        fragmentQueue.add(fragment)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transactions)
        enableToolbarBackButton()

        btAdd.setOnClickListener(buttonsClickListener)
        btReplace.setOnClickListener(buttonsClickListener)
        btRemove.setOnClickListener(buttonsClickListener)

        updateBackStackDisplay()
        supportFragmentManager.addOnBackStackChangedListener {
            LogUtil.e("onBackStackChanged()")
            updateBackStackDisplay()
        }
    }

    private fun updateBackStackDisplay() {
        tvBackStackState.text = String.format(Locale.ENGLISH, BACK_STACK_COUNT_PATTERN,
                supportFragmentManager.backStackEntryCount)
    }

    private fun add(fragment: Fragment, backStack: Boolean) {
        FragmentUtil
                .addFragment(supportFragmentManager, fragment, R.id.flTransactionsContainer, backStack)
    }

    private fun replace(fragment: Fragment, backStack: Boolean) {
        FragmentUtil
                .replaceFragment(supportFragmentManager, fragment, R.id.flTransactionsContainer, backStack)
    }

    private fun remove(fragment: Fragment?, backStack: Boolean) {
        if (fragment != null)
            FragmentUtil.removeFragment(supportFragmentManager, fragment, backStack)
        else
            UiNotificationsUtils.showDevMessage(this, "There is no fragments!")
    }

    companion object {
        private val BACK_STACK_COUNT_PATTERN = "Back stack count: %d"
    }
}