package com.shevart.androidcorelearn.view.customlayoutmanager

import android.support.v7.widget.RecyclerView

@Suppress("unused")
class SimpleCustomLayoutManager : RecyclerView.LayoutManager() {

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams =
            RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.MATCH_PARENT)


    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        // obtain View from recycle (create new or recycle previously created view)
        val view = recycler.getViewForPosition(0)
        // add this view to recycleView
        addView(view)
        // measure te view ???
        measureChildWithMargins(view, 0, 0)
        // draw view
        layoutDecorated(view, 0, 0, width, (height * 0.45).toInt())
    }
}