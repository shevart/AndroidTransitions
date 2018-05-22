package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment
import com.shevart.androidtransitions.common.MockSimpleListAdapter
import com.shevart.androidtransitions.common.SimpleItem
import kotlinx.android.synthetic.main.fragment_screen_a.*

class ScreenAFragment : AbsFragment() {
    private lateinit var adapter: MockSimpleListAdapter

    override fun provideLayoutResId() = R.layout.fragment_screen_a

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MockSimpleListAdapter()
        adapter.updateItems(getItems())
        adapter.setOnItemClickListener(this::onItemSelected)
        rvSimpleItemsScreenA.adapter = adapter
        rvSimpleItemsScreenA.layoutManager = LinearLayoutManager(view.context)
    }

    private fun onItemSelected(item: SimpleItem) {
        (activity as FragmentsScreenContentTransitionActivity).openDetail(item)
    }

    private fun getItems() =
            (activity as FragmentsScreenContentTransitionActivity).provideItems()
}