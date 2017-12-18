package com.shevart.androidcorelearn.fragments.lifecycle_sample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup

import com.shevart.androidcorelearn.utils.LifecycleLogUtil

abstract class BaseLifecycleLogsFragment : Fragment() {

    override fun onInflate(context: Context?, attrs: AttributeSet, savedInstanceState: Bundle) {
        super.onInflate(context, attrs, savedInstanceState)
        logMessage("onInflate(), context")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        logMessage("onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMessage("onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logMessage("onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logMessage("onViewCreated()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logMessage("onActivityCreated()")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logMessage("onViewStateRestored()")
    }

    override fun onStart() {
        super.onStart()
        logMessage("onStart()")
    }

    override fun onResume() {
        super.onResume()
        logMessage("onResume()")
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        logMessage("onCreateOptionsMenu()")
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        logMessage("onPrepareOptionsMenu()")
    }

    override fun onPause() {
        super.onPause()
        logMessage("onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        logMessage("onSaveInstanceState()")
    }

    override fun onStop() {
        super.onStop()
        logMessage("onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logMessage("onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logMessage("onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        logMessage("onDetach()")
    }

    /***
     * <h3>Developer hint</h3>
     * Use this method only for logging [Fragment] lifecycle methods and public constructor
     * @param msg - String which will be print in logs
     */
    protected fun logMessage(msg: String) {
        LifecycleLogUtil.logMessage(provideFragmentName(), msg)
    }

    protected abstract fun provideFragmentName(): String
}
