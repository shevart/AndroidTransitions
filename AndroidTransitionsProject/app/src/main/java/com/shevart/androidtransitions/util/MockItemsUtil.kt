package com.shevart.androidtransitions.util

import android.support.annotation.DrawableRes
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.common.SimpleItem
import java.util.*
import kotlin.collections.ArrayList

private val random = Random()

fun nextSimpleItemsList(size: Int = 25): List<SimpleItem> {
    return ArrayList<SimpleItem>().apply {
        for (i in 0..size) {
            add(nextSimpleItem(i))
        }
    }
}

fun nextSimpleItem(number: Int) = SimpleItem(
        imageResId = nextImageResId(),
        title = nextTitle(number),
        text = nextText(number))

@DrawableRes
private fun nextImageResId(): Int {
    return R.drawable.sea
}

private fun nextTitle(number: Int): String {
    return "Title $number"
}

private fun nextText(number: Int): String {
    return "Text $number"
}