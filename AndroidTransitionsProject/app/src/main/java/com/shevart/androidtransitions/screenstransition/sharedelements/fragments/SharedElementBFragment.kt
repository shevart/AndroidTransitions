package com.shevart.androidtransitions.screenstransition.sharedelements.fragments

import android.os.Bundle
import android.support.transition.TransitionInflater
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.util.imageViewTransitionName
import kotlinx.android.synthetic.main.layout_detail_screen.*

class SharedElementBFragment : AbsFragment() {
    override fun provideLayoutResId() = R.layout.fragment_shared_element_b

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater
                .from(context)
                .inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = getSimpleItem(arguments)
        ivDetailScreenImage.setImageResource(item.imageResId)
        tvDetailScreenTitle.text = item.title
        tvDetailScreenText.text = item.text

        ivDetailScreenImage.transitionName = item.imageViewTransitionName()
    }

    companion object {
        private const val SIMPLE_ITEM_KEY = "SIMPLE_ITEM_KEY"

        fun getInstance(simpleItem: SimpleItem) = SharedElementBFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SIMPLE_ITEM_KEY, simpleItem)
            }
        }

        fun getSimpleItem(arg: Bundle?): SimpleItem = arg!!.getParcelable(SIMPLE_ITEM_KEY)
    }
}