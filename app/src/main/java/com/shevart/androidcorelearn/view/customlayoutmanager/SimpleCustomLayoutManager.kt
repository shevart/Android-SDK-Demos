package com.shevart.androidcorelearn.view.customlayoutmanager

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

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
        // measure the view
        val widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        measureChildWithMargins(view, widthSpec, heightSpec)
        // draw view
        layoutDecorated(view, 0, 0, width, (height * 0.45).toInt())
    }

    private fun measureChildWithDecorationsAndMargin(child: View, widthSpec: Int, heightSpec: Int) {
        val decorRect = Rect()
        calculateItemDecorationsForChild(child, decorRect)

        val lp = child.layoutParams as RecyclerView.LayoutParams
        val calculatedWidthSpec = updateSpecWithExtra(widthSpec,
                lp.leftMargin + decorRect.left, lp.rightMargin + decorRect.right)
        val calculatedHeightSpec = updateSpecWithExtra(heightSpec,
                lp.topMargin + decorRect.top, lp.bottomMargin + decorRect.bottom)
        child.measure(calculatedWidthSpec, calculatedHeightSpec)
    }

    private fun updateSpecWithExtra(spec: Int, startInset: Int, endInset: Int): Int {
        if (startInset == 0 && endInset == 0) {
            return spec
        }

        val mode = View.MeasureSpec.getMode(spec)
        if (mode == View.MeasureSpec.AT_MOST || mode == View.MeasureSpec.EXACTLY) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(spec) - startInset - endInset, mode)
        }

        return spec
    }
}