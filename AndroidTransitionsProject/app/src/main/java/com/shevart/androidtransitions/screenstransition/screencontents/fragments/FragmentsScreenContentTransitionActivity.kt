package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity

class FragmentsScreenContentTransitionActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_screen_content_transition)
        enableToolbarBackButton()
    }
}
