package com.shevart.androidtransitions.screenstransition

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.util.Launcher
import kotlinx.android.synthetic.main.activity_screen_transitions_topic.*

class ScreenTransitionsTopicActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_transitions_topic)
        enableToolbarBackButton()

        btFragmentsContentTransition.setOnClickListener {
            Launcher.ScreenTransitions.Content.fragmentsSample(this)
        }
    }
}
