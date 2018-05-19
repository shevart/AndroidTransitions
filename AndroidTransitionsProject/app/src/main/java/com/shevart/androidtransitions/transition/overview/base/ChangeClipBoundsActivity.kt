package com.shevart.androidtransitions.transition.overview.base

import android.graphics.Rect
import android.support.transition.ChangeClipBounds
import android.support.transition.Scene
import android.support.transition.Transition
import android.widget.ImageView
import com.shevart.androidtransitions.R

class ChangeClipBoundsActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_clip_bounds

    override fun provideTitle() = getString(R.string.change_clip_bounds)!!

    override fun provideLayoutIdSceneA() = R.layout.layout_transition_change_clip_bounds_overview_scene_a

    override fun provideLayoutIdSceneB() = R.layout.layout_transition_change_clip_bounds_overview_scene_b

    override fun provideSceneB(): Scene {
        return Scene(provideRootView()).apply {
            setEnterAction {
                val imageView = findViewById<ImageView>(R.id.ivForChangeClipBounds)!!
                var clipBounds = imageView.clipBounds
                if (clipBounds == null) {
                    clipBounds = Rect()
                    imageView.getWindowVisibleDisplayFrame(clipBounds)
                }
                clipBounds.bottom /= 2
                clipBounds.top /= 2
                clipBounds.left /= 2
                clipBounds.right /= 2
                imageView.clipBounds = clipBounds
            }
        }
    }

    override fun provideTransition(): Transition {
        return ChangeClipBounds()
    }
}
