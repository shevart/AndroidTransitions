package com.shevart.androidtransitions.screenstransition.sharedelements.fragments

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.util.nextSimpleItemsList

class FragmentsSharedElementsActivity : AbsActivity(), SharedElementsSimpleIItemAdapter.OnItemViewClickListener {
    private val items: List<SimpleItem> by lazy { nextSimpleItemsList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_shared_elements)
        enableToolbarBackButton()

        if (supportFragmentManager.findFragmentById(R.id.flFragmentsContainer) == null) {
            startContent()
        }
    }

    override fun onItemSelected(item: SimpleItem, view: View) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragmentsContainer, SharedElementBFragment.getInstance(item))
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
}
