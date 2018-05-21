package com.shevart.androidtransitions.common

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.BaseRVAdapter

@Suppress("unused")
class MockSimpleListAdapter : BaseRVAdapter<SimpleItem, MockSimpleListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(inflateView(parent, R.layout.item_simple))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            ivImage.setImageResource(item.imageResId)
            tvTitle.setText(item.titleResId)
            tvText.setText(item.textResId)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivSceneSameView)!!
        val tvTitle = itemView.findViewById<TextView>(R.id.tvSimpleItemTitle)!!
        val tvText = itemView.findViewById<TextView>(R.id.tvSimpleItemText)!!
    }
}