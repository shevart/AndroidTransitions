package com.shevart.androidtransitions.advanced.clean.code

import android.app.Activity
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Window

fun Activity.initContentTransition() {
    window.apply {
        requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        enterTransition = Slide()
    }
}

fun Activity.initSharedElementsTransition() {
    window.apply {
        requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        sharedElementEnterTransition = TransitionInflater
                .from(this@initSharedElementsTransition)
                .inflateTransition(android.R.transition.move)
    }
}