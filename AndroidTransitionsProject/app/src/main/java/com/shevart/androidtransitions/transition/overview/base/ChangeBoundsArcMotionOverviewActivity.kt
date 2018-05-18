package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.ArcMotion
import android.support.transition.ChangeBounds
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class ChangeBoundsArcMotionOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_bounds_arch_motion

    override fun provideTitle() = getString(R.string.change_bounds_plus_arc_motion)!!

    override fun provideTransition(): Transition {
        return ChangeBounds().apply {
            setPathMotion(ArcMotion())
        }
    }
}