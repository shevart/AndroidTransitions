package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.AutoTransition
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class AutoTransitionOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.auto_transition

    override fun provideTitle() = getString(R.string.auto_transition)!!

    override fun provideTransition(): Transition {
        return AutoTransition()
    }
}