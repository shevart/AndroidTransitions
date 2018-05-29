package com.shevart.androidtransitions.screenstransition.sharedelements.activity

import android.content.Intent
import android.graphics.Path
import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.PatternPathMotion
import android.view.Window
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.util.imageViewTransitionName
import kotlinx.android.synthetic.main.layout_detail_screen.*

class SharedElementsBActivity : AbsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementsInit()
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

    private fun sharedElementsInit() {
        // todo before use stop use SharedElements theme
        window.apply {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
//            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            sharedElementEnterTransition = ChangeBounds()
//            sharedElementEnterTransition = ChangeBounds().apply {
//                pathMotion = PatternPathMotion(createPath())
//            }
//            sharedElementReturnTransition = ChangeBounds().apply { pathMotion = ArcMotion() }
        }
    }

    private fun createPath() = Path().apply {
        moveTo(0f,0f)
        quadTo(0f,0f, 1f, 0.0f)
        quadTo(1f,0.0f, 0.3f, 0.6f)
        quadTo(0.3f,0.6f, 1f, 1f)
    }

    companion object {
        const val SIMPLE_ITEM = "SIMPLE_ITEM"

        fun getSimpleItem(intent: Intent) = intent.getParcelableExtra<SimpleItem>(SIMPLE_ITEM)!!
    }
}
