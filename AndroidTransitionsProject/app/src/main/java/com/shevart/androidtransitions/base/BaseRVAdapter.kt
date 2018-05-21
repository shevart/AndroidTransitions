package com.shevart.androidtransitions.base

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shevart.androidtransitions.util.inflate

@Suppress("unused")
abstract class BaseRVAdapter<M, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    private val items = ArrayList<M>()
    protected var itemClickListener: OnItemClickListener<M>? = null

    protected fun inflateView(parent: ViewGroup, @LayoutRes layoutRes: Int): View =
            inflate(parent, layoutRes)

    override fun getItemCount() = items.size

    fun setOnItemClickListener(itemClickListener: OnItemClickListener<M>) {
        this.itemClickListener = itemClickListener
    }

    fun setOnItemClickListener(action: (item: M) -> Unit) {
        this.itemClickListener = object : OnItemClickListener<M> {
            override fun onItemClick(item: M) {
                action(item)
            }
        }
    }

    fun removeOnItemClickListener() {
        this.itemClickListener = null
    }

    protected open fun getItem(pos: Int) = items[pos]

    open fun updateItems(items: List<M>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface OnItemClickListener<M> {
        fun onItemClick(item: M)
    }
}