package com.shevart.androidtransitions.transitionmanager.begindelayedsample

import android.os.Bundle
import android.support.transition.AutoTransition
import android.support.transition.TransitionManager
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.util.doOnEnd
import com.shevart.androidtransitions.util.setHeight
import com.shevart.androidtransitions.util.dpToPx
import kotlinx.android.synthetic.main.activity_begin_delayed_sample.*
import java.util.*

class BeginDelayedSampleActivity : AbsActivity() {
    private val oneDpInPixels: Int by lazy { 1.dpToPx() }
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin_delayed_sample)
        enableToolbarBackButton()

        cvLayoutChangesAnim.setOnClickListener {
            updateView()
        }
    }

    private fun updateView() {
        flTestContent.visibility = View.INVISIBLE
        // create transition and set listener
        val transition = AutoTransition()
        transition.doOnEnd { showWithAlpha() }
        // schedule animation
        TransitionManager.beginDelayedTransition(cvLayoutChangesAnim, transition)
        // change view
        val heightPx = nextRandomHeightPx()
        showToast("oneDpInPixels=$oneDpInPixels")
        showToast("heightPx=$heightPx")
        flTestContent.setHeight(heightPx)
    }

    private fun showWithAlpha() {
        TransitionManager.beginDelayedTransition(cvLayoutChangesAnim)
        flTestContent.visibility = View.VISIBLE
    }

    private fun nextRandomHeightPx() = oneDpInPixels * (50 + random.nextInt(250))
}
