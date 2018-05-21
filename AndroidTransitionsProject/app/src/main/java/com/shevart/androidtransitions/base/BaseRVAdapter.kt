package com.shevart.androidtransitions.base

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shevart.androidtransitions.util.inflate

abstract class BaseRVAdapter<M, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    private val items = ArrayList<M>()

    protected fun inflateView(parent: ViewGroup, @LayoutRes layoutRes: Int): View =
            inflate(parent, layoutRes)

    override fun getItemCount() = items.size

    protected open fun getItem(pos: Int) = items[pos]

    protected open fun updateItems(items: List<M>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}