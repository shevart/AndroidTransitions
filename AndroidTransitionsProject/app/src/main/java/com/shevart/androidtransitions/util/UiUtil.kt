package com.shevart.androidtransitions.util

import android.content.res.Resources
import android.widget.FrameLayout

fun Int.dpToPx() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun FrameLayout.setHeight(heightPx: Int) {
    this.layoutParams = this.layoutParams.apply {
        height = heightPx
    }
}