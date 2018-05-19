package com.shevart.androidtransitions.transition.overview.base

import android.support.transition.ChangeScroll
import android.support.transition.Scene
import android.support.transition.Transition
import android.widget.ScrollView
import com.shevart.androidtransitions.R

class ChangeScrollOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_scroll

    override fun provideTitle() = getString(R.string.change_scroll)!!

    override fun provideLayoutIdSceneA() = R.layout.layout_transition_change_scroll_scene

    override fun provideSceneB(): Scene {
        return Scene(provideRootView()).apply {
            setEnterAction {
                val scrollView = findViewById<ScrollView>(R.id.svChangeScroll)!!
                scrollView.scrollTo(0, scrollView.height * 3)
            }
        }
    }

    override fun provideTransition(): Transition {
        return ChangeScroll()
    }
}