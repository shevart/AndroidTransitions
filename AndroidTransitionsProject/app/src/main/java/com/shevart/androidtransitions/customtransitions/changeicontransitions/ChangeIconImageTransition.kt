package com.shevart.androidtransitions.customtransitions.changeicontransitions

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import android.support.transition.Transition
import android.support.transition.TransitionValues
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Animate only view's with the same start-end size.
 *
 */
// todo review invalidate moment - try to avoid invalidate and request layout
class ChangeIconImageTransition : Transition() {
    companion object {
        private const val PROPNAME_DRAWABLE = "customTransitions:changeIconImageTransition:drawable"
        private const val PROPNAME_IMAGE_HEIGHT = "customTransitions:changeIconImageTransition:height"
        private const val PROPNAME_IMAGE_WIDTH = "customTransitions:changeIconImageTransition:width"
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(sceneRoot: ViewGroup,
                                startValues: TransitionValues?,
                                endValues: TransitionValues?): Animator? {
        if (startValues == null || endValues == null) {
            return null
        }
        if (!isImageHeightAndWidthWithTheSameSize(startValues, endValues)) {
            return null
        }
        val imageView = endValues.view as? ImageView
                ?: return null

        imageView.setImageDrawable(obtainDrawable(startValues))
        return ValueAnimator.ofInt(255, 0, 255).apply {
            addUpdateListener { animation ->
                val alpha = animation.animatedValue as? Int
                alpha?.let { a ->
                    if (imageView.imageAlpha < a) {
                        imageView.setImageDrawable(obtainDrawable(endValues))
                    }
                    imageView.imageAlpha = a
                }
            }
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    imageView.setImageDrawable(obtainDrawable(endValues))
                }

                override fun onAnimationCancel(animation: Animator?) {
                    imageView.setImageDrawable(obtainDrawable(endValues))
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }
    }

    private fun captureValues(transitionValues: TransitionValues) {
        if (!isValidCapturedView(transitionValues)) {
            return
        }

        val drawable = extractDrawable(transitionValues)
                ?: return

        transitionValues.values[PROPNAME_DRAWABLE] = drawable
        transitionValues.values[PROPNAME_IMAGE_HEIGHT] = transitionValues.view.height
        transitionValues.values[PROPNAME_IMAGE_WIDTH] = transitionValues.view.width
    }

    private fun extractDrawable(transitionValues: TransitionValues) =
            (transitionValues.view as? ImageView)?.drawable

    private fun isValidCapturedView(transitionValues: TransitionValues) =
            transitionValues.view is ImageView && transitionValues.view.visibility == View.VISIBLE

    private fun isImageHeightAndWidthWithTheSameSize(startValues: TransitionValues,
                                                     endValues: TransitionValues): Boolean {
        return obtainImageHeight(startValues) == obtainImageWith(endValues)
                && obtainImageWith(startValues) == obtainImageWith(endValues)
    }

    private fun obtainImageHeight(transitionValues: TransitionValues) =
            transitionValues.values[PROPNAME_IMAGE_HEIGHT] as? Int

    private fun obtainImageWith(transitionValues: TransitionValues) =
            transitionValues.values[PROPNAME_IMAGE_WIDTH] as? Int

    private fun obtainDrawable(transitionValues: TransitionValues) =
            transitionValues.values[PROPNAME_DRAWABLE] as Drawable
}