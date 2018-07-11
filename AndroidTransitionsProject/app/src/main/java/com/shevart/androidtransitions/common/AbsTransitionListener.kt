package com.shevart.androidtransitions.common

import android.transition.Transition

abstract class AbsTransitionListener : Transition.TransitionListener {
    override fun onTransitionEnd(transition: Transition?) {
        onTransitionStopOrCancel(transition)
    }

    override fun onTransitionResume(transition: Transition?) {

    }

    override fun onTransitionPause(transition: Transition?) {

    }

    override fun onTransitionCancel(transition: Transition?) {
        onTransitionStopOrCancel(transition)
    }

    override fun onTransitionStart(transition: Transition?) {

    }

    protected open fun onTransitionStopOrCancel(transition: Transition?) {

    }
}