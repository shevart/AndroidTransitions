package com.shevart.androidtransitions.advanced.clean.code.delegates

import android.transition.Transition

@Suppress("unused")
interface ContentTransitionProvider {
    fun provideEnterTransition(): Transition?

    fun provideExitTransition(): Transition?

    fun provideReturnTransition(): Transition?

    fun provideReenterTransition(): Transition?
}