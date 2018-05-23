package com.shevart.androidtransitions.screenstransition.screencontents.activity.programmatically

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Explode
import android.support.v7.widget.LinearLayoutManager
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.MockSimpleItemAdapter
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.screencontents.activity.programmatically.SecondContentProgrammaticallyActivity.Companion.SIMPLE_ITEM
import com.shevart.androidtransitions.util.nextSimpleItemsList
import kotlinx.android.synthetic.main.activity_first_content_programmatically.*

class FirstContentProgrammaticallyActivity : AbsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content transitions
        setContentTransition()
        setContentView(R.layout.activity_first_content_programmatically)
        initToolbar()

        val adapter = MockSimpleItemAdapter()
        adapter.updateItems(nextSimpleItemsList())
        adapter.setOnItemClickListener(this::onItemSelected)
        rvPCScreenA.adapter = adapter
        rvPCScreenA.layoutManager = LinearLayoutManager(this)
    }

    private fun setContentTransition() {
        window.apply {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            exitTransition = Explode()
        }
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.activity_content_programmatically)
    }

    private fun onItemSelected(item: SimpleItem) {
        val intent = Intent(this, SecondContentProgrammaticallyActivity::class.java)
        intent.putExtra(SIMPLE_ITEM, item)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
