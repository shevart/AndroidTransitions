package com.shevart.androidtransitions.advanced.polish

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_polish_finish.*

class PolishFinishActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTransitions()
        setContentView(R.layout.activity_polish_finish)
        supportActionBar?.hide()

        llSearchBooksRoot.transitionName = "transition_name_search_books_root"
    }

    private fun initTransitions() {
        window.apply {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

            sharedElementEnterTransition = TransitionInflater
                    .from(this@PolishFinishActivity)
                    .inflateTransition(android.R.transition.move)
        }
    }
}
