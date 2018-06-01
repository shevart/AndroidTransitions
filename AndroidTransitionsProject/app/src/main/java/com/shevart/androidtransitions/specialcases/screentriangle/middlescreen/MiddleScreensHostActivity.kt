package com.shevart.androidtransitions.specialcases.screentriangle.middlescreen

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import com.shevart.androidtransitions.R
import kotlinx.android.synthetic.main.activity_middle_screens_host.*

class MiddleScreensHostActivity : AppCompatActivity() {
    private val transitionListener = object : Transition.TransitionListener {
        override fun onTransitionEnd(transition: Transition) {
            showContent()
        }

        override fun onTransitionResume(transition: Transition) {
        }

        override fun onTransitionPause(transition: Transition) {
        }

        override fun onTransitionCancel(transition: Transition) {
            showContent()
        }

        override fun onTransitionStart(transition: Transition) {
            hideContent()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSharedElementsTransition()
        setContentView(R.layout.activity_middle_screens_host)

        hideContent()

        btMiddleBackToFirst.setOnClickListener {
            hideContent()
            finishAfterTransition()
        }
        btMiddleBackToSecond.setOnClickListener {
            hideContent()
            setResult(Activity.RESULT_OK)
            finishAfterTransition()
        }
    }

    private fun hideContent() {
        btMiddleBackToFirst.visibility = View.INVISIBLE
        btMiddleBackToSecond.visibility = View.INVISIBLE
    }

    private fun showContent() {
        btMiddleBackToFirst.visibility = View.VISIBLE
        btMiddleBackToSecond.visibility = View.VISIBLE
    }

    private fun setSharedElementsTransition() {
        window.apply {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            sharedElementEnterTransition = provideSharedElementsTransition().addListener(transitionListener)
            sharedElementReturnTransition = provideSharedElementsTransition()
        }
    }

    private fun provideSharedElementsTransition() =
            TransitionInflater
                    .from(this)
                    .inflateTransition(android.R.transition.move)
}
