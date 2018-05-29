package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.util.nextSimpleItemsList

class FragmentsScreenContentTransitionActivity : AbsActivity(),
        SampleContentTransitionsProvider by NoTransitions {
    private val simpleItems: List<SimpleItem> by lazy { nextSimpleItemsList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_screen_content_transition)
        enableToolbarBackButton()

        if (supportFragmentManager.findFragmentById(R.id.flFragmentScreenA) == null) {
            startContent()
        }
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

    fun provideItems() = simpleItems

    private fun startContent() {
        val fragment = ScreenAFragment()
        fragment.exitTransition = getListScreenExitTransition()
        fragment.reenterTransition = getListScreenReenterTransition()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.flFragmentScreenA, fragment)
                .commit()
    }
}