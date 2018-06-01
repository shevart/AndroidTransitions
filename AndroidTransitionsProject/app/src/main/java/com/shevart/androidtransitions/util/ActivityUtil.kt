package com.shevart.androidtransitions.util

import android.app.Activity

fun Int.resultCodeStr(): String =
        when(this) {
            Activity.RESULT_OK -> "RESULT_OK"
            Activity.RESULT_CANCELED -> "RESULT_CANCELED"
            else -> "$this"
        }