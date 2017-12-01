package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.SimpleItem
import kotlinx.android.synthetic.main.fragment_detail_screen.*

import java.util.Locale

class DetailScreenFragment : Fragment() {
    private val simpleItemFromArguments: SimpleItem?
        get() = if (arguments != null)
            arguments.getParcelable(SimpleItem::class.java.simpleName)
        else
            null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_detail_screen, container, false)

        val item = simpleItemFromArguments
        if (item != null)
            update(item)
        return view
    }

    fun update(item: SimpleItem) {
        tvSimpleItemId.text = String.format(Locale.ENGLISH, ID_FORMAT_PATTERN, item.id)
        tvSimpleItemTitle.text = item.title
        tvSimpleItemDescription.text = item.description
    }

    companion object {
        private val ID_FORMAT_PATTERN = "Id: %d"

        fun getInstance(item: SimpleItem): DetailScreenFragment {
            val fragment = DetailScreenFragment()
            val args = Bundle()
            args.putParcelable(SimpleItem::class.java.simpleName, item)
            fragment.arguments = args
            return fragment
        }
    }
}