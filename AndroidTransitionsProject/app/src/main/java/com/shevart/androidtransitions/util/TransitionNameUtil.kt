package com.shevart.androidtransitions.util

import com.shevart.androidtransitions.common.SimpleItem

fun SimpleItem.rootViewTransitionName() = "root_id=$id"

fun SimpleItem.imageViewTransitionName() = "image_id=$id"