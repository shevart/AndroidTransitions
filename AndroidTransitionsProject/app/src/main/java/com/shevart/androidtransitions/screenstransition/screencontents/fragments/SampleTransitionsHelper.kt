@file:Suppress("unused")

package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.support.transition.*
import android.view.Gravity
import com.shevart.androidtransitions.R


private const val transitionDuration = 300L / 2

object NoTransitions : SampleContentTransitionsProvider {
    override fun getListScreenExitTransition(): Transition? = null

    override fun getListScreenReenterTransition(): Transition? = null

    override fun getDetailScreenEnterTransition(): Transition? = null

    override fun getDetailScreenReturnTransition(): Transition? = null
}

object SimpleTransitions : SampleContentTransitionsProvider {
    override fun getListScreenExitTransition() = Slide(Gravity.START).baseInit()

    override fun getListScreenReenterTransition() = Slide(Gravity.START).baseInitWithStartDelay()

    override fun getDetailScreenEnterTransition() = Slide(Gravity.END).baseInitWithStartDelay()

    override fun getDetailScreenReturnTransition() = Slide(Gravity.END).baseInit()
}

object NiceTransitions : SampleContentTransitionsProvider {
    override fun getListScreenExitTransition() =
            Explode().baseInit()

    override fun getListScreenReenterTransition() =
            Explode().baseInitWithStartDelay()

    override fun getDetailScreenEnterTransition() =
            TransitionSet().apply {
                addTransition(Fade())
                addTransition(Slide())
                baseInitWithStartDelay()
            }

    override fun getDetailScreenReturnTransition() =
            TransitionSet().apply {
                addTransition(Slide(Gravity.BOTTOM))
                baseInit()
            }
}

object AcuteTransitions : SampleContentTransitionsProvider {
    override fun getListScreenExitTransition(): Transition? = null

    override fun getListScreenReenterTransition() = Fade().baseInitWithStartDelay()

    override fun getDetailScreenEnterTransition() =
            TransitionSet().apply {
                addTransition(Slide(Gravity.TOP).addTarget(R.id.ivDetailScreenImage))
                addTransition(Slide(Gravity.BOTTOM).addTarget(R.id.tvDetailScreenTitle).addTarget(R.id.tvDetailScreenText))
                baseInit()
            }

    override fun getDetailScreenReturnTransition() =
            TransitionSet().apply {
                addTransition(Slide(Gravity.TOP).addTarget(R.id.ivDetailScreenImage))
                addTransition(Slide(Gravity.BOTTOM).addTarget(R.id.tvDetailScreenTitle).addTarget(R.id.tvDetailScreenText))
                baseInit()
            }
}

private fun Transition.baseInit(duration: Long = transitionDuration,
                                startDelay: Long = 0) =
        this.apply {
            this.duration = duration
            this.startDelay = startDelay
        }

private fun Transition.baseInitWithStartDelay(duration: Long = transitionDuration,
                                startDelay: Long = duration / 3) =
        this.apply {
            this.duration = duration
            this.startDelay = startDelay
        }