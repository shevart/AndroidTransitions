@file:Suppress("unused")

package com.shevart.androidtransitions.advanced.clean.code.delegates

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.Window

fun Activity.initContentTransitionByDelegate(tp: ContentTransitionProvider) {
    window.apply {
        requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        enterTransition = tp.provideEnterTransition()
        exitTransition = tp.provideExitTransition()
        reenterTransition = tp.provideReenterTransition()
        returnTransition = tp.provideReturnTransition()
    }
}

fun Fragment.initContentTransitionByDelegate(tp: ContentTransitionProvider) {
    enterTransition = tp.provideEnterTransition()
    exitTransition = tp.provideExitTransition()
    reenterTransition = tp.provideReenterTransition()
    returnTransition = tp.provideReturnTransition()
}