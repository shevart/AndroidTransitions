package com.shevart.androidtransitions.advanced.polish

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import android.view.View
import android.view.Window
import androidx.core.view.doOnPreDraw
import androidx.core.view.postDelayed
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_polish_start.*

class PolishStartActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentTransition()
        setContentView(R.layout.activity_polish_start)
        supportActionBar?.hide()

        postponeEnterTransition()
        tvBooksTitle.doOnPreDraw {
            tvBooksTitle.postDelayed(55) { startPostponedEnterTransition() }
        }

        cvSearchBox.transitionName = "transition_name_search_books_root"
        cvSearchBox.setOnClickListener {
            openSearchBooksScreen(cvSearchBox)
        }
    }

    private fun openSearchBooksScreen(view: View) {
        val intent = Intent(this, PolishFinishActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this,
                view, view.transitionName).toBundle()
        startActivity(intent, options)
    }

    private fun initContentTransition() {
        window.apply {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            allowEnterTransitionOverlap = true
            this.enterTransition = TransitionSet().apply {
                addTransition(Slide(Gravity.TOP).addTarget(R.id.tvBooksTitle))
                addTransition(Slide(Gravity.TOP).addTarget(R.id.tvBooksDescription))
                addTransition(Fade().addTarget(R.id.cvSearchBox))
                duration = 300L
            }
        }
    }
}
