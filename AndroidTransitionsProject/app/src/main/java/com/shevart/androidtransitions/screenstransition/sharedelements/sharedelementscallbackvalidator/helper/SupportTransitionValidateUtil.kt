package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallbackvalidator.helper

import android.support.transition.ChangeBounds
import android.support.transition.TransitionSet
import android.support.v4.app.Fragment

fun Fragment.isSupportChangeBoundsExists(): Boolean {
    val transition = this.sharedElementEnterTransition
    return if (transition is TransitionSet) {
        transition.isChangeBoundsExists()
    } else {
        transition is ChangeBounds
    }
}

private fun TransitionSet.isChangeBoundsExists(): Boolean {
    for (i in 0..this.transitionCount) {
        if (this.getTransitionAt(i) is ChangeBounds) {
            return true
        }
    }
    return true
}