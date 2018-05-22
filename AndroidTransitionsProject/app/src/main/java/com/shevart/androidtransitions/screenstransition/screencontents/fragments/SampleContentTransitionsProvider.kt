package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.support.transition.Transition

interface SampleContentTransitionsProvider {
    fun getListScreenExitTransition(): Transition?

    fun getListScreenReenterTransition(): Transition?

    fun getDetailScreenEnterTransition(): Transition?

    fun getDetailScreenReturnTransition(): Transition?
}