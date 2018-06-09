package com.shevart.androidtransitions.util

import android.support.transition.Transition
import android.support.v4.app.SharedElementCallback
import android.util.Log
import android.view.View

fun Transition.doOnEnd(action: () -> Unit): Transition.TransitionListener {
    val listener = object : Transition.TransitionListener {
        override fun onTransitionEnd(transition: Transition) {
            action()
        }

        override fun onTransitionResume(transition: Transition) {
        }

        override fun onTransitionPause(transition: Transition) {
        }

        override fun onTransitionCancel(transition: Transition) {
        }

        override fun onTransitionStart(transition: Transition) {
        }
    }
    this.addListener(listener)
    return listener
}

fun getDebuggingSharedElementsCallback(tag: String) = object : SharedElementCallback() {
    override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
        super.onMapSharedElements(names, sharedElements)

        if (names != null) {
            Log.e(tag, "-- Names --")
            names.forEach { Log.e(tag, it) }
            Log.e(tag, "--       --")
        }
        if (sharedElements != null) {
            Log.e(tag, "-- SharedElements --")
            sharedElements.entries.forEach { Log.e(tag, it.toString()) }
            Log.e(tag, "--       --")
        }
    }
}