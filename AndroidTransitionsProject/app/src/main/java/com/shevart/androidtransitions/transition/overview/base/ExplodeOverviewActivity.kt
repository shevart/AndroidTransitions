package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.Explode
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class ExplodeOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.explode

    override fun provideTitle() = getString(R.string.explode)!!

    override fun provideTransition(): Transition {
        return Explode()
    }
}
