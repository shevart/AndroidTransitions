package com.shevart.androidtransitions.transition.overview.base

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.transition.Scene
import android.support.transition.Transition
import android.support.transition.TransitionManager


import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_transition_base_overview.*
import kotlinx.android.synthetic.main.layout_base_transition_overview_form.*

abstract class AbsTransitionBaseActivity : AbsActivity() {
    private lateinit var sceneA: Scene
    private lateinit var sceneB: Scene

    @DrawableRes
    abstract fun provideIcon(): Int

    abstract fun provideTitle(): String

    abstract fun provideTransition(): Transition


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_base_overview)
        enableToolbarBackButton()

        tvBaseTransitionTitle.text = provideTitle()
        ivBaseTransitionLogo.setImageResource(provideIcon())

        sceneA = Scene.getSceneForLayout(flSceneConteiner,
                R.layout.layout_transition_base_overview_scene_a, this)
        sceneB = Scene.getSceneForLayout(flSceneConteiner,
                R.layout.layout_transition_base_overview_scene_b, this)

        btSceneA.setOnClickListener {
            TransitionManager.go(sceneA, provideTransition().setBaseParams())
        }
        btSceneB.setOnClickListener {
            TransitionManager.go(sceneB, provideTransition().setBaseParams())
        }
    }

    private fun Transition.setBaseParams(): Transition {
        duration = TWO_SECONDS
        return this
    }

    companion object {
        private const val TWO_SECONDS = 2000L
    }
}