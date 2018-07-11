package com.shevart.androidtransitions.util

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import androidx.core.animation.addListener

fun View.showWithAlpha(): Animator {
    this.visibility = View.VISIBLE
    this.alpha = 0.0f
    val animator = ValueAnimator.ofFloat(0.0f, 1.0f)
    animator.addUpdateListener { value ->
        this.alpha = value.animatedValue as Float
    }
    animator.addListener(onEnd = {
        this.alpha = 1.0f
    })
    animator.duration = 300L
    animator.start()
    return animator
}

fun View.hideWithAlpha(): Animator {
    val animator = ValueAnimator.ofFloat(1.0f, 0.0f)
    animator.addUpdateListener { value ->
        this.alpha = value.animatedValue as Float
    }
    animator.addListener(onEnd = {
        this.visibility = View.INVISIBLE
    })
    animator.duration = 300L
    animator.start()
    return animator
}