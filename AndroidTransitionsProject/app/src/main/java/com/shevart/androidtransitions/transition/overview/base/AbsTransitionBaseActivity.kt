package com.shevart.androidtransitions.transition.overview.base

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
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

    protected fun provideRootView() = flSceneConteiner!!

    @LayoutRes
    protected open fun provideLayoutIdSceneA(): Int = R.layout.layout_transition_base_overview_scene_a

    @LayoutRes
    protected open fun provideLayoutIdSceneB(): Int = R.layout.layout_transition_base_overview_scene_b

    protected open fun provideSceneA() =
            Scene.getSceneForLayout(provideRootView(), provideLayoutIdSceneA(), this)

    protected open fun provideSceneB() =
            Scene.getSceneForLayout(provideRootView(), provideLayoutIdSceneB(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_base_overview)
        enableToolbarBackButton()

        tvBaseTransitionTitle.text = provideTitle()
        ivBaseTransitionLogo.setImageResource(provideIcon())

        sceneA = provideSceneA()
        sceneB = provideSceneB()

        btSceneA.setOnClickListener {
            TransitionManager.go(sceneA, provideTransition().setBaseParams())
        }
        btSceneB.setOnClickListener {
            TransitionManager.go(sceneB, provideTransition().setBaseParams())
        }

        sceneA.enter()
    }

    private fun Transition.setBaseParams(): Transition {
        duration = DURATION
        return this
    }

    companion object {
        private const val DURATION = 1000L
    }
}