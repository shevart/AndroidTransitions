package com.shevart.androidtransitions.screenstransition.screencontents.activity.bytheme

import android.content.Intent
import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import kotlinx.android.synthetic.main.layout_detail_screen.*

class ContentTransitionByThemeScreenBActivity : AbsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_transition_by_theme_screen_b)
        initToolbar()

        val item = getSimpleItem(intent)
        ivDetailScreenImage.setImageResource(item.imageResId)
        tvDetailScreenTitle.text = item.title
        tvDetailScreenText.text = item.text
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.activity_content_by_theme)
    }

    companion object {
        const val SIMPLE_ITEM = "SIMPLE_ITEM"

        fun getSimpleItem(intent: Intent) = intent.getParcelableExtra<SimpleItem>(SIMPLE_ITEM)!!
    }
}