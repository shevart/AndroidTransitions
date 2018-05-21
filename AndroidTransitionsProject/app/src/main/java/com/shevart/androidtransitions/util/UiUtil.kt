package com.shevart.androidtransitions.util

import android.content.res.Resources
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

fun Int.dpToPx() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun FrameLayout.setHeight(heightPx: Int) {
    this.layoutParams = this.layoutParams.apply {
        height = heightPx
    }
}

fun inflate(parent: ViewGroup, @LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
}