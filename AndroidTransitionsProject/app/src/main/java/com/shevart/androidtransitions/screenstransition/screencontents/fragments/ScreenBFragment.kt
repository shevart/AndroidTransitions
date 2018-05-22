package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment
import com.shevart.androidtransitions.common.SimpleItem
import kotlinx.android.synthetic.main.layout_detail_screen.*

class ScreenBFragment : AbsFragment() {
    override fun provideLayoutResId() = R.layout.fragment_screen_b

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val simpleItem = getSimpleItems(arguments)
        ivDetailScreenImage.setImageResource(simpleItem.imageResId)
        tvDetailScreenTitle.text = simpleItem.title
        tvDetailScreenText.text = simpleItem.text
    }

    companion object {
        private const val SIMPLE_ITEM_KEY = "SIMPLE_ITEM_KEY"

        fun getInstance(simpleItem: SimpleItem) = ScreenBFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SIMPLE_ITEM_KEY, simpleItem)
            }
        }

        fun getSimpleItems(arg: Bundle?): SimpleItem = arg!!.getParcelable(SIMPLE_ITEM_KEY)
    }
}
