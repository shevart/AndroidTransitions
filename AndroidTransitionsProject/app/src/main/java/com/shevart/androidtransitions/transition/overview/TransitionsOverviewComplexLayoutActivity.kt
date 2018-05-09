@file:Suppress("PrivatePropertyName")

package com.shevart.androidtransitions.transition.overview

import android.os.Bundle
import android.support.transition.*

import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_transitions_complex_layout_overview.*

// todo add transition constructor!
class TransitionsOverviewComplexLayoutActivity : AbsActivity() {
    private val TWO_SECONDS = 2000L

    private lateinit var sceneA: Scene
    private lateinit var sceneB: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transitions_complex_layout_overview)
        enableToolbarBackButton()

        sceneA = Scene.getSceneForLayout(flTransitionOverviewContainer,
                R.layout.layout_transition_overview_scene_a, this)
        sceneB = Scene.getSceneForLayout(flTransitionOverviewContainer,
                R.layout.layout_transition_overview_scene_b, this)

        btGoToSceneA.setOnClickListener {
            TransitionManager.go(sceneA, getCurrentTransition())
        }
        btGoToSceneB.setOnClickListener {
            TransitionManager.go(sceneB, getCurrentTransition())
        }

    }

    private fun getCurrentTransition() = TransitionSet().apply {
        val changeBound = ChangeBounds()
        addTransition(changeBound)

//        val changeClipBound = ChangeClipBounds()
//        addTransition(changeClipBound)

        addTransition(ChangeTransform())

        // Slide
//        addTransition(Slide()) // whole layout
//        addTransition(Slide().excludeTarget(ConstraintLayout::class.java, true)) // only child views

        duration = TWO_SECONDS
    }
}
