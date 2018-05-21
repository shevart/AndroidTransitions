package com.shevart.androidtransitions.common

import android.os.Parcelable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimpleItem(@DrawableRes
                      val imageResId: Int,
                      val title: String,
                      val text: String) : Parcelable