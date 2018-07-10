package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallbackvalidator

import android.os.Bundle
import android.support.transition.Fade
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.MockItemListDetailHost
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallbackvalidator.helper.SharedElementsFragmentsHelper
import com.shevart.androidtransitions.util.nextSimpleItemsList

class FragmentsSharedElementsCallbackValidatorActivity : AbsActivity(),
        MockItemListDetailHost {
    private val items: List<SimpleItem> by lazy { nextSimpleItemsList() }
    private val validator = SharedElementsFragmentsHelper()

    override fun provideItems() = items

    override fun onItemSelected(item: SimpleItem, view: View) {
        openDetailScreen(item, view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_shared_elements_validator)
        enableToolbarBackButton()

        if (findCurrentFragment() == null) {
            startContent()
        }
    }

    private fun openDetailScreen(item: SimpleItem, view: View) {
        val fragment = SecvBFragment.getInstance(item)
        fragment.enterTransition = Fade()
        fragment.enterTransition = Fade().apply { duration = 100L }

        val prevFragment = findCurrentFragment()!!
        validator.validateSharedElementsScreenTransition(
                screenTransitionName = "A-to-B",
                fragmentFrom = prevFragment,
                fragmentTo = fragment)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragmentsContainer, fragment)
                .addToBackStack(null)
                .addSharedElement(view, view.transitionName)
                .commit()
    }

    private fun startContent() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flFragmentsContainer, SecvAFragment())
                .setReorderingAllowed(true)
                .commit()
    }

    private fun findCurrentFragment() =
            supportFragmentManager.findFragmentById(R.id.flFragmentsContainer)
}
