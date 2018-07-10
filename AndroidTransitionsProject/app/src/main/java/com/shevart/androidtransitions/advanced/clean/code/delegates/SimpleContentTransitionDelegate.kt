package com.shevart.androidtransitions.advanced.clean.code.delegates

import android.transition.Slide

@Suppress("ImplicitNullableNothingType", "unused")
class SimpleContentTransitionDelegate : ContentTransitionProvider {
    override fun provideEnterTransition() = Slide()

    override fun provideExitTransition() = Slide()

    override fun provideReturnTransition() = null

    override fun provideReenterTransition() = null
}