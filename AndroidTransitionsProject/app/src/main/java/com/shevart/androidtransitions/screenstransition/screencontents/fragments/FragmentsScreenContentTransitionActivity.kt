package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import android.support.transition.Fade
import android.support.transition.Slide
import android.support.transition.TransitionSet
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem

class FragmentsScreenContentTransitionActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_screen_content_transition)
        enableToolbarBackButton()

        if(supportFragmentManager.findFragmentById(R.id.flFragmentScreenA) == null) {
            startContent()
        }
    }

    private fun startContent() {
        val fragment = ScreenAFragment()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.flFragmentScreenA, fragment)
                .commit()
    }

    fun openDetail(item: SimpleItem) {
        
    }

    private fun createScreenBEnterTransition() = TransitionSet().apply {
        addTransition(Fade())
        addTransition(Slide())
        duration = 600L
    }
}
