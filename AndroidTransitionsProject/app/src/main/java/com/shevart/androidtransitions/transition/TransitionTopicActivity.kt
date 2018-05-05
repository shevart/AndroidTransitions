package com.shevart.androidtransitions.transition

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity

class TransitionTopicActivity : AbsActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_topic)
        enableToolbarBackButton()


    }
}
