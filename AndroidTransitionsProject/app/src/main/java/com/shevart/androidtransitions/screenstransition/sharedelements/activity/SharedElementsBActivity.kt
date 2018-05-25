package com.shevart.androidtransitions.screenstransition.sharedelements.activity

import android.content.Intent
import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.util.imageViewTransitionName
import kotlinx.android.synthetic.main.layout_detail_screen.*

class SharedElementsBActivity : AbsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_elements_b)
        initToolbar()

        val item = getSimpleItem(intent)
        ivDetailScreenImage.setImageResource(item.imageResId)
        tvDetailScreenTitle.text = item.title
        tvDetailScreenText.text = item.text

        ivDetailScreenImage.transitionName = item.imageViewTransitionName()
    }

    private fun initToolbar() {
        enableToolbarBackButton()
        setTitle(R.string.shared_elements_by_theme)
    }

    companion object {
        const val SIMPLE_ITEM = "SIMPLE_ITEM"

        fun getSimpleItem(intent: Intent) = intent.getParcelableExtra<SimpleItem>(SIMPLE_ITEM)!!
    }
}
