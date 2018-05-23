package com.shevart.androidtransitions.screenstransition.sharedelements

import android.view.View
import android.view.ViewGroup
import com.shevart.androidtransitions.common.MockSimpleItemAdapter
import com.shevart.androidtransitions.common.SimpleItem

class SharedElementsSimpleIItemAdapter : MockSimpleItemAdapter() {
    var onItemViewClickListener: OnItemViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            super.onCreateViewHolder(parent, viewType).apply {
                rootView.setOnClickListener {
                    onItemViewClickListener?.onItemSelected(getItem(adapterPosition), ivImage)
                }
            }

    interface OnItemViewClickListener {
        fun onItemSelected(item: SimpleItem, view: View)
    }
}