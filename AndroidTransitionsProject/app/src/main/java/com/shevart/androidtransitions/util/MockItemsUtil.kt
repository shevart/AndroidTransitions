package com.shevart.androidtransitions.util

import android.support.annotation.DrawableRes
import com.shevart.androidtransitions.common.SimpleItem
import java.util.*
import kotlin.collections.ArrayList

private val random = Random()

private var id = 1

fun nextSimpleItemsList(size: Int = 25): List<SimpleItem> {
    return ArrayList<SimpleItem>().apply {
        for (i in 0..size) {
            add(nextSimpleItem(i))
        }
    }
}

fun nextSimpleItem(number: Int) = SimpleItem(
        id = id++,
        imageResId = nextImageResId(),
        title = nextTitle(number),
        text = longText)

@DrawableRes
private fun nextImageResId() =
        stockImagesMap[random.nextInt(stockImagesMap.size)]!!

private fun nextTitle(number: Int) = titlesList[random.nextInt(titlesList.size)]