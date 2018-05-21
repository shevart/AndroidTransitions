package com.shevart.androidtransitions.util

import android.support.transition.Transition

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