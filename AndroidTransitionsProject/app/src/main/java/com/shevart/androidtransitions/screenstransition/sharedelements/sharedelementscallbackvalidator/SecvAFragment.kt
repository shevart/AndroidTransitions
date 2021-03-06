package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallbackvalidator

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment
import com.shevart.androidtransitions.common.getItemsHost
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import kotlinx.android.synthetic.main.fragment_shared_element_a.*

class SecvAFragment : AbsFragment(){
    override fun provideLayoutResId() = R.layout.fragment_shared_element_a

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SharedElementsSimpleIItemAdapter()
        adapter.updateItems(getItems())
        adapter.onItemViewClickListener = getItemsHost()
        rvSimpleItemsScreenA.adapter = adapter
        rvSimpleItemsScreenA.layoutManager = LinearLayoutManager(context!!)
    }

    private fun getItems() = getItemsHost().provideItems()
}