package com.shevart.androidtransitions.specialcases.screentriangle.middlescreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.Window
import com.shevart.androidtransitions.R

class MiddleScreensHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSharedElementsTransition()
        setContentView(R.layout.activity_middle_screens_host)
    }

    private fun setSharedElementsTransition() {
        window.apply {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            sharedElementEnterTransition = provideSharedElementsTransition()
        }
    }

    private fun provideSharedElementsTransition() =
            TransitionInflater
                    .from(this)
                    .inflateTransition(android.R.transition.move)
}
