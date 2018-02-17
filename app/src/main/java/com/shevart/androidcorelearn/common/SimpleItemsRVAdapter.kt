@file:Suppress("unused")

package com.shevart.androidcorelearn.common

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.utils.UiUtil
import java.util.*

class SimpleItemsRVAdapter(private val simpleItemSelectedListener: OnSimpleItemSelectedListener,
                           items: List<SimpleItem> = ArrayList(),
                           useDifferentBackgroundColors: Boolean = false) : RecyclerView.Adapter<SimpleItemsRVAdapter.ViewHolder>() {
    private val items = ArrayList<SimpleItem>()
    private var useDifferentBackgroundColors: Boolean

    init {
        update(items)
        this.useDifferentBackgroundColors = useDifferentBackgroundColors
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UiUtil.inflate(parent, R.layout.item_simple_rv))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvSimpleItem.text = item.title
        if (useDifferentBackgroundColors) {
            setBackgroundColor(holder.itemView)
        }
        holder.tvSimpleItem.setOnClickListener {
            simpleItemSelectedListener.onSimpleItemSelected(
                    items[holder.adapterPosition])
        }
    }

    override fun getItemCount() = items.size

    fun update(newItems: List<SimpleItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun isUseDifferentBackgroundColors() = useDifferentBackgroundColors

    fun setUseDifferentBackgroundColors(useDifferentBackgroundColors: Boolean) {
        this.useDifferentBackgroundColors = useDifferentBackgroundColors
        notifyDataSetChanged()
    }


    private fun setBackgroundColor(view: View) {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.blue_light))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSimpleItem: TextView = itemView.findViewById<View>(R.id.tvSimpleItem) as TextView

    }

    interface OnSimpleItemSelectedListener {
        fun onSimpleItemSelected(simpleItem: SimpleItem)
    }
}