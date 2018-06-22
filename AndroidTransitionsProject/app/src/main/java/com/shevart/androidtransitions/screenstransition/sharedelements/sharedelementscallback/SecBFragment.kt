package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallback

import android.os.Bundle
import android.support.transition.Slide
import android.support.transition.TransitionInflater
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallback.helper.validateSharedElementsTransition
import com.shevart.androidtransitions.util.imageViewTransitionName
import kotlinx.android.synthetic.main.layout_detail_screen.*

class SecBFragment : AbsFragment() {
    override fun provideLayoutResId() = R.layout.fragment_shared_element_b

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater
                .from(context)
                .inflateTransition(android.R.transition.move)

        /**
         * for invalid transition
         */
//        sharedElementEnterTransition = null // there is no transition
//        sharedElementEnterTransition = Slide() // this transition cannot to move your sharedElements on the screen
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // check is there sharedElements transition?
        this.validateSharedElementsTransition(true)

        val item = getSimpleItem(arguments)
        ivDetailScreenImage.setImageResource(item.imageResId)
        tvDetailScreenTitle.text = item.title
        tvDetailScreenText.text = item.text

        /**
         * for transitionNames duplicate problem
         */
//        tvDetailScreenTitle.transitionName = "bug"
//        tvDetailScreenText.transitionName = "bug"

        ivDetailScreenImage.transitionName = item.imageViewTransitionName()


        /**
         * for viewNotReady problem
         */
//        view.visibility = View.GONE
//        view.doOnPreDraw {
//            view.postDelayed(10) { view.visibility = View.VISIBLE }
//        }
    }

    companion object {
        private const val SIMPLE_ITEM_KEY = "SIMPLE_ITEM_KEY"

        fun getInstance(simpleItem: SimpleItem) = SecBFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SIMPLE_ITEM_KEY, simpleItem)
            }
        }

        fun getSimpleItem(arg: Bundle?): SimpleItem = arg!!.getParcelable(SIMPLE_ITEM_KEY)
    }
}