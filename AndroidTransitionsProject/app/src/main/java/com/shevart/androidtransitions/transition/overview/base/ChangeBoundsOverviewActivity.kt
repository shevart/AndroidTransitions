package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.ChangeBounds
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class ChangeBoundsOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideTitle() = getString(R.string.change_bounds)!!

    override fun provideIcon() = R.drawable.change_bounds

    override fun provideTransition(): Transition {
        return ChangeBounds()
    }
}
