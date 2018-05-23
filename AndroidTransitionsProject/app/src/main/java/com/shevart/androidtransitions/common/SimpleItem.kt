package com.shevart.androidtransitions.common

import android.os.Parcelable
import android.support.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimpleItem(val id: Int,
                      @DrawableRes
                      val imageResId: Int,
                      val title: String,
                      val text: String) : Parcelable