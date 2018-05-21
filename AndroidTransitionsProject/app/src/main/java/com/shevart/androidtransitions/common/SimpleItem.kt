package com.shevart.androidtransitions.common

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

class SimpleItem(
        @DrawableRes
        val imageResId: Int,
        @StringRes
        val titleResId: Int,
        @StringRes
        val textResId: Int)