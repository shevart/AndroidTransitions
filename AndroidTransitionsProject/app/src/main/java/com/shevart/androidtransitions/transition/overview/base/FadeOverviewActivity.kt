package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.Fade
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class FadeOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.fade

    override fun provideTitle() = getString(R.string.fade)!!

    override fun provideTransition(): Transition {
        return Fade()
    }
}
