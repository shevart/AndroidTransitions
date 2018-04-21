package com.shevart.androidtransitions.scene.samples.searchbar

import android.os.Bundle
import android.transition.*
import android.view.Gravity
import android.widget.ImageView
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_search_bar_scene_sample.*

class SearchBarSceneSampleActivity : AbsActivity() {
    private lateinit var sceneFirst: Scene
    private lateinit var sceneSecond: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_bar_scene_sample)
        hideToolbar()

        sceneFirst = Scene.getSceneForLayout(cvSceneRoot, R.layout.layout_search_bar_scene_sample_first_content, this)
        sceneSecond = Scene.getSceneForLayout(cvSceneRoot, R.layout.layout_search_bar_scene_sample_second_content, this)

        val startTransition = TransitionSet()
        startTransition.startDelay = 500L
        startTransition.duration = 300L
        startTransition.ordering = TransitionSet.ORDERING_TOGETHER

        val titleEnterTransition = TransitionSet().apply {
                        addTransition(Fade())
            addTransition(Slide(Gravity.END))
            addTarget(R.id.tvTitle)
        }
        startTransition.addTransition(titleEnterTransition)

        val slide = Slide(Gravity.END)
                .addTarget(R.id.ivSearch)
                .addTarget(R.id.ivOptionMenu)
        startTransition.addTransition(slide)
        startTransition.addTransition(Slide(Gravity.START).addTarget(R.id.ivMenu))

        TransitionManager.go(sceneFirst, startTransition)

        sceneFirst.sceneRoot.findViewById<ImageView>(R.id.ivMenu).setOnClickListener {
            TransitionManager.go(sceneSecond, startTransition)
        }
    }
}
