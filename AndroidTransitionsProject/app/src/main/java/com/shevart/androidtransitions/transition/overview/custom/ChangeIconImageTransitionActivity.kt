package com.shevart.androidtransitions.transition.overview.custom

import android.support.transition.ChangeBounds
import android.support.transition.Transition
import android.support.transition.TransitionSet
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.customtransitions.changeicontransitions.ChangeIconImageTransition
import com.shevart.androidtransitions.transition.overview.base.AbsTransitionBaseActivity

class ChangeIconImageTransitionActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_clip_bounds

    override fun provideTitle() = "ChangeIconImageTransition"

    override fun provideLayoutIdSceneA() = R.layout.layout_transition_icon_image_transition_overview_scene_a

    override fun provideLayoutIdSceneB() = R.layout.layout_transition_icon_image_transition_overview_scene_b

    override fun provideTransition(): Transition {
        return TransitionSet().apply {
            addTransition(ChangeBounds())
            addTransition(ChangeIconImageTransition().addTarget(R.id.ivIcon))

        }
    }
}
