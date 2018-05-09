package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.Slide
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class SlideOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.slide

    override fun provideTitle() = getString(R.string.slide)!!

    override fun provideTransition(): Transition {
        return Slide()
    }


}
