package com.shevart.androidtransitions.specialcases.screentriangle.middlescreen

import android.app.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.SharedElementCallback
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.util.nextSimpleItem
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
    private val sharedElementCallback = object : SharedElementCallback() {
        override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
            super.onMapSharedElements(names, sharedElements)

            val newTransitionName = getString(R.string.shared_element_triangle_2)
            names?.add(newTransitionName)
            sharedElements?.put(newTransitionName, clMiddleScreenRoot)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSharedElementsTransition()
        setContentView(R.layout.activity_middle_screens_host)
        setEnterSharedElementCallback(sharedElementCallback)

        hideContent()

        btMiddleBackToFirst.setOnClickListener {
            hideContent()
            finishAfterTransition()
        }
        btMiddleBackToSecond.setOnClickListener {
//            clMiddleScreenRoot.transitionName = getString(R.string.shared_element_triangle_2)
            hideContent()
            setResult(Activity.RESULT_OK, getFakeResult())
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

    private fun getFakeResult() = Intent().apply { putExtra("SIMPLE_ITEM", nextSimpleItem(1)) }
}
