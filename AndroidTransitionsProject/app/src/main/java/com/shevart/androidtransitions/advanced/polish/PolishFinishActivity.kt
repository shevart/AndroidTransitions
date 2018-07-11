package com.shevart.androidtransitions.advanced.polish

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import androidx.core.animation.addListener
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.AbsTransitionListener
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.util.hideWithAlpha
import com.shevart.androidtransitions.util.nextSimpleItemsList
import com.shevart.androidtransitions.util.showWithAlpha
import kotlinx.android.synthetic.main.activity_polish_finish.*

class PolishFinishActivity : AbsActivity() {
    private val enterSharedElementsListener = object : AbsTransitionListener() {
        override fun onTransitionStopOrCancel(transition: Transition?) {
            llSearchBooksRoot.forEach { it.showWithAlpha() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTransitions()
        setContentView(R.layout.activity_polish_finish)
        supportActionBar?.hide()

        ibClose.setOnClickListener {
            closeScreen()
        }
        llSearchBooksRoot.transitionName = "transition_name_search_books_root"

        rvSearchBooks.layoutManager = LinearLayoutManager(this)
        rvSearchBooks.adapter = SharedElementsSimpleIItemAdapter().apply { updateItems(nextSimpleItemsList(30)) }

        llSearchBooksRoot.forEach { it.visibility = View.INVISIBLE }
    }

    override fun onBackPressed() {
        closeScreen()
    }

    private fun closeScreen() {
        llSearchBooksRoot.forEachIndexed { index, view ->
            if (index == llSearchBooksRoot.childCount - 1) {
                view.hideWithAlpha().addListener(onEnd = {
                    finishAfterTransition()
                })
            } else {
                view.hideWithAlpha()
            }
        }
    }

    private fun initTransitions() {
        window.apply {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

            sharedElementEnterTransition = TransitionInflater
                    .from(this@PolishFinishActivity)
                    .inflateTransition(android.R.transition.move).apply {
                        addListener(enterSharedElementsListener)
                        duration = 300L
                    }
        }
    }
}
