package com.shevart.androidtransitions.screenstransition.sharedelements.fragments

import android.os.Bundle
import android.support.transition.Fade
import android.support.v4.app.SharedElementCallback
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.util.createDevLogSharedElementCallback
import com.shevart.androidtransitions.util.nextSimpleItemsList

class FragmentsSharedElementsActivity : AbsActivity(), SharedElementsSimpleIItemAdapter.OnItemViewClickListener {
    private val items: List<SimpleItem> by lazy { nextSimpleItemsList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_shared_elements_validator)
        enableToolbarBackButton()

        if (findCurrentFragment() == null) {
            startContent()
        }
    }

    override fun onItemSelected(item: SimpleItem, view: View) {
        val fragment = SharedElementBFragment.getInstance(item)
        fragment.enterTransition = Fade()
        fragment.enterTransition = Fade().apply { duration = 100L }

        // todo remove after test!
        val prevFragment = supportFragmentManager.findFragmentById(R.id.flFragmentsContainer)
        prevFragment?.setEnterSharedElementCallback(createDevLogSharedElementCallback("Enter", "ScreenA"))
        prevFragment?.setExitSharedElementCallback(createDevLogSharedElementCallback("Exit", "ScreenA"))

        fragment.setEnterSharedElementCallback(createDevLogSharedElementCallback("Enter", "ScreenB"))
        fragment.setExitSharedElementCallback(createDevLogSharedElementCallback("Exit", "ScreenB"))


        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragmentsContainer, fragment)
                .addToBackStack(null)
                .addSharedElement(view, view.transitionName)
                .commit()
    }

    fun getMockItemsList() = items

    private fun startContent() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flFragmentsContainer, SharedElementAFragment())
                .commit()
    }

    private fun findCurrentFragment() =
            supportFragmentManager.findFragmentById(R.id.flFragmentsContainer)
}
