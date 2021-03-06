package com.shevart.androidtransitions.screenstransition.screencontents.activity.bytheme

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.MockSimpleItemAdapter
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.screencontents.activity.bytheme.ContentTransitionByThemeScreenBActivity.Companion.SIMPLE_ITEM
import com.shevart.androidtransitions.util.nextSimpleItemsList
import kotlinx.android.synthetic.main.activity_content_transition_by_theme_screen_a.*

@Suppress("UNUSED_PARAMETER")
class ContentTransitionByThemeScreenAActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_transition_by_theme_screen_a)
        initToolbar()

        val adapter = MockSimpleItemAdapter()
        adapter.updateItems(nextSimpleItemsList())
        adapter.setOnItemClickListener(this::onItemSelected)
        rvNotifications.layoutManager = LinearLayoutManager(this)
        rvNotifications.adapter = adapter
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.activity_content_by_theme)
    }

    private fun onItemSelected(item: SimpleItem) {
        val intent = Intent(this, ContentTransitionByThemeScreenBActivity::class.java)
        intent.putExtra(SIMPLE_ITEM, item)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
