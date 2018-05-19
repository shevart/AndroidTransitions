package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.ChangeBounds
import android.support.transition.ChangeImageTransform
import android.support.transition.Transition
import android.support.transition.TransitionSet
import com.shevart.androidtransitions.R

class ChangeImageTransformOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_image_transform

    override fun provideTitle() = getString(R.string.change_image_transform)!!

    override fun provideLayoutIdSceneA() = R.layout.layout_transition_change_image_transform_overview_scene_a

    override fun provideLayoutIdSceneB() = R.layout.layout_transition_change_image_transform_overview_scene_b

    override fun provideTransition(): Transition {
//        return ChangeImageTransform()
        return TransitionSet().apply {
            addTransition(ChangeImageTransform())
            addTransition(ChangeBounds())
        }
    }
}
