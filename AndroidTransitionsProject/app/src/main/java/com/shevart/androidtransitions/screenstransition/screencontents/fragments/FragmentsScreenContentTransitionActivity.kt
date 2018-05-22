package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import android.support.transition.*
import android.view.Gravity
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem

class FragmentsScreenContentTransitionActivity : AbsActivity() {
    private val transitionDuration = 300L / 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_screen_content_transition)
        enableToolbarBackButton()

        if (supportFragmentManager.findFragmentById(R.id.flFragmentScreenA) == null) {
            startContent()
        }
    }

    private fun startContent() {
        val fragment = ScreenAFragment()
        fragment.exitTransition = getListScreenExitTransition()
        fragment.reenterTransition = getListScreenReenterTransition()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.flFragmentScreenA, fragment)
                .commit()
    }


    fun openDetail(item: SimpleItem) {
        val fragment = ScreenBFragment.getInstance(item)
        fragment.enterTransition = getDetailScreenEnterTransition()
        fragment.returnTransition = getDetailScreenReturnTransition()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragmentScreenA, fragment)
                .addToBackStack(fragment::class.java.simpleName)
                .commit()
    }

    private fun getListScreenExitTransition() =
            Explode().apply {
                duration = transitionDuration
            }

    private fun getListScreenReenterTransition() =
            Explode().apply {
                duration = transitionDuration
                startDelay = transitionDuration / 3
            }

    private fun getDetailScreenEnterTransition() =
            TransitionSet().apply {
                addTransition(Fade())
                addTransition(Slide())
                duration = transitionDuration
                startDelay = transitionDuration / 3
            }

    private fun getDetailScreenReturnTransition() =
            TransitionSet().apply {
                addTransition(Slide(Gravity.BOTTOM))
                duration = transitionDuration
            }
}
