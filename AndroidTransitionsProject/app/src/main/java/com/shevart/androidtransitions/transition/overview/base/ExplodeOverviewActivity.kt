package com.shevart.androidtransitions.transition.overview.base

import android.graphics.Rect
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionSet
import android.view.View
import android.widget.FrameLayout
import com.shevart.androidtransitions.R

@Suppress("FoldInitializerAndIfToElvis", "unused", "ConstantConditionIf", "MemberVisibilityCanBePrivate", "UnnecessaryVariable")
class ExplodeOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.explode

    override fun provideTitle() = getString(R.string.explode)!!

    override fun provideLayoutIdSceneA() = R.layout.layout_explode_base_scene_a

    override fun provideLayoutIdSceneB() = R.layout.layout_explode_base_scene_b

    override fun provideTransition(): Transition {
        return getExplodeForWholeLayout()
//        return getExplodeForEveryChildViewWithEpicenterCallback()
    }

    private fun getExplodeForWholeLayout() = Explode()

    private fun getExplodeForEveryChildView() = TransitionSet().apply {
        // smart way
        addTransition(Explode().addTarget(FrameLayout::class.java))

        // we won't use no smart ways!
        if (true) return@apply

        // no smart way)
        addTransition(Explode().addTarget(R.id.frameLayout))
        addTransition(Explode().addTarget(R.id.frameLayout2))
        addTransition(Explode().addTarget(R.id.frameLayout3))
        addTransition(Explode().addTarget(R.id.frameLayout4))
        addTransition(Explode().addTarget(R.id.frameLayout5))
        addTransition(Explode().addTarget(R.id.frameLayout6))
        addTransition(Explode().addTarget(R.id.frameLayout7))
        addTransition(Explode().addTarget(R.id.frameLayout8))
        addTransition(Explode().addTarget(R.id.frameLayout9))
    }

    private fun getExplodeForEveryChildViewWithEpicenterCallback() = TransitionSet().apply {
        // smart way
        val explode = Explode()
        explode.epicenterCallback = createEpicenterCallback()

        addTransition(explode)

        //.addTarget(FrameLayout::class.java)

        // we won't use no smart ways!
        if (true) return@apply

        // no smart way)
        val epicenterCallback = createEpicenterCallback()
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout2))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout3))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout4))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout5))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout6))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout7))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout8))
        addTransition(Explode().withEpicenterCallback(epicenterCallback).addTarget(R.id.frameLayout9))
    }

    fun createEpicenterCallback(): Transition.EpicenterCallback {
        var rect: Rect? = null
        val centralView = findViewForEpicenterCallback()
        if (centralView != null) {
            rect = Rect()
            centralView.getGlobalVisibleRect(rect)
        }
        return object : Transition.EpicenterCallback() {
            override fun onGetEpicenter(transition: Transition) = rect
        }
    }

    private fun Explode.withEpicenterCallback(epicenterCallback: Transition.EpicenterCallback) = this.apply {
        this.epicenterCallback = epicenterCallback
    }

    private fun findViewForEpicenterCallback() = findViewById<View>(R.id.frameLayout6)
}
