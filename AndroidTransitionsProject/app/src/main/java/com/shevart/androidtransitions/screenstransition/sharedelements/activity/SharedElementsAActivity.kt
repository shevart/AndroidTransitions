package com.shevart.androidtransitions.screenstransition.sharedelements.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.SharedElementsSimpleIItemAdapter
import com.shevart.androidtransitions.util.nextSimpleItemsList
import kotlinx.android.synthetic.main.activity_shared_elements_a.*

class SharedElementsAActivity : AbsActivity(), SharedElementsSimpleIItemAdapter.OnItemViewClickListener {
    private val adapter = SharedElementsSimpleIItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_elements_a)
        initToolbar()

        adapter.updateItems(nextSimpleItemsList())
        adapter.onItemViewClickListener = this
        rvSimpleItemsScreenA.layoutManager = LinearLayoutManager(this)
        rvSimpleItemsScreenA.adapter = adapter
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
}
