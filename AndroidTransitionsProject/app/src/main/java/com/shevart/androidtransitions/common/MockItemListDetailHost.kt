package com.shevart.androidtransitions.common

import android.support.v4.app.Fragment
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter

interface MockItemListDetailHost : SharedElementsSimpleIItemAdapter.OnItemViewClickListener {
    fun provideItems(): List<SimpleItem>
}

fun Fragment.getItemsHost() =
        activity as MockItemListDetailHost