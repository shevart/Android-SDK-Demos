package com.shevart.androidcorelearn.fragments.back_stack_sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import android.text.Editable
import android.view.View
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.common.ShortTextWatcher
import com.shevart.androidcorelearn.utils.LogUtil
import com.shevart.androidcorelearn.utils.UiScreenMockUtils
import kotlinx.android.synthetic.main.activity_fragment_transactions.*
import kotlinx.android.synthetic.main.element_fragments_back_stack_control_panel.*
import java.util.*

class FragmentsBackStackSampleActivity : AbsActivity() {
    private val buttonsClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btPutNewFragment -> putNewFragment()
            R.id.btRemoveByBackStackName -> removeFragmentByBackStackName()
            else -> throw IllegalArgumentException("Check it!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_back_stack_sample)
        enableToolbarBackButton()

        etBackStackName.addTextChangedListener(object : ShortTextWatcher() {
            override fun afterTextChanged(s: Editable) {
                updateButtonsEnableState(s.isNotEmpty())
            }
        })
        btRemoveByBackStackName.setOnClickListener(buttonsClickListener)
        btPutNewFragment.setOnClickListener(buttonsClickListener)
        updateButtonsEnableState(false)
        updateBackStackDisplay()

        supportFragmentManager.addOnBackStackChangedListener {
            LogUtil.e("onBackStackChanged()")
            updateBackStackDisplay()
        }
    }

    private fun putNewFragment() {
        putNewFragment(UiScreenMockUtils.nextDetailSimpleItemFragment(), etBackStackName.text.toString())
    }

    private fun removeFragmentByBackStackName() {
        removeByBackStackName(etBackStackName!!.text.toString(), cbPopInclusive.isChecked)
    }

    private fun updateButtonsEnableState(enable: Boolean) {
        btPutNewFragment.isEnabled = enable
        btRemoveByBackStackName.isEnabled = enable
        tvButtonsEnableState.visibility = if (enable) View.INVISIBLE else View.VISIBLE
    }

    private fun putNewFragment(fragment: Fragment, backStackName: String) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flBackStackContainer, fragment)
                .addToBackStack(backStackName)
                .commit()
    }

    private fun updateBackStackDisplay() {
        tvBackStackState.text = String.format(Locale.ENGLISH, BACK_STACK_COUNT_PATTERN,
                supportFragmentManager.backStackEntryCount)
    }

    private fun removeByBackStackName(backStackName: String, isPopBackStackInclusive: Boolean) {
        supportFragmentManager.popBackStack(backStackName,
                if (isPopBackStackInclusive) POP_BACK_STACK_INCLUSIVE else 0)
    }

    companion object {
        private val BACK_STACK_COUNT_PATTERN = "Back stack count: %d"
    }
}