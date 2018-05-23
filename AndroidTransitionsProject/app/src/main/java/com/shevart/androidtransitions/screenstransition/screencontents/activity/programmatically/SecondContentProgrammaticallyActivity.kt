package com.shevart.androidtransitions.screenstransition.screencontents.activity.programmatically

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.screencontents.activity.bytheme.ContentTransitionByThemeScreenBActivity
import kotlinx.android.synthetic.main.layout_detail_screen.*

class SecondContentProgrammaticallyActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content transitions
        setContentTransition()
        setContentView(R.layout.activity_second_content_programmatically)
        initToolbar()

        val item = ContentTransitionByThemeScreenBActivity.getSimpleItem(intent)
        ivDetailScreenImage.setImageResource(item.imageResId)
        tvDetailScreenTitle.text = item.title
        tvDetailScreenText.text = item.text
    }

    private fun setContentTransition() {
        window.apply {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

            enterTransition = Fade()
        }
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.activity_content_programmatically)
    }

    companion object {
        const val SIMPLE_ITEM = "SIMPLE_ITEM"

        fun getSimpleItem(intent: Intent) = intent.getParcelableExtra<SimpleItem>(SIMPLE_ITEM)!!
    }
}
