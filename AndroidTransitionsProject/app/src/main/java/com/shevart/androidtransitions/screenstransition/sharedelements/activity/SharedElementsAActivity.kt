package com.shevart.androidtransitions.screenstransition.sharedelements.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.Fade
import android.view.View
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.util.createDevLogSharedElementCallback
import com.shevart.androidtransitions.util.nextSimpleItemsList
import kotlinx.android.synthetic.main.activity_shared_elements_a.*

class SharedElementsAActivity : AbsActivity(), SharedElementsSimpleIItemAdapter.OnItemViewClickListener {
    private val adapter = SharedElementsSimpleIItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementsInit()
        setContentView(R.layout.activity_shared_elements_a)
        initToolbar()

        adapter.updateItems(nextSimpleItemsList())
        adapter.onItemViewClickListener = this
        rvSimpleItemsScreenA.layoutManager = LinearLayoutManager(this)
        rvSimpleItemsScreenA.adapter = adapter


        // todo remove after test
        setEnterSharedElementCallback(createDevLogSharedElementCallback("Enter", "ScreenA"))
        setExitSharedElementCallback(createDevLogSharedElementCallback("Exit", "ScreenA"))
    }

    override fun onItemSelected(item: SimpleItem, view: View) {
        val intent = Intent(this, SharedElementsBActivity::class.java)
        intent.putExtra(SharedElementsBActivity.SIMPLE_ITEM, item)
        val  activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                view, view.transitionName)
        startActivity(intent, activityOptions.toBundle())
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.shared_elements_by_theme)
    }

    private fun sharedElementsInit() {
        // todo before use stop use SharedElements theme
//        window.apply {
//            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
//            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//
//            sharedElementExitTransition = Fade()
//            sharedElementReturnTransition = Fade()
//        }
    }
}