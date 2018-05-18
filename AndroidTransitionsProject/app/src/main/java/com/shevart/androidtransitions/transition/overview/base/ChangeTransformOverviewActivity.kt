package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.ChangeBounds
import android.support.transition.ChangeTransform
import android.support.transition.Transition
import android.support.transition.TransitionSet
import com.shevart.androidtransitions.R

class ChangeTransformOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_transform

    override fun provideTitle() = getString(R.string.change_transform)!!

    override fun provideLayoutIdSceneA() = R.layout.layout_transition_change_transform_overview_scene_a

    override fun provideLayoutIdSceneB() = R.layout.layout_transition_change_transform_overview_scene_b

    override fun provideTransition(): Transition {
//        return ChangeTransform() // if you return only ChangeTransform the View will be rotate only!

        return TransitionSet().apply {
            addTransition(ChangeTransform())
            addTransition(ChangeBounds())
        }
    }
}
