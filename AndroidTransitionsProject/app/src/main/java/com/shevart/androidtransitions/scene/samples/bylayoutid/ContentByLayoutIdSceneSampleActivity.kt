package com.shevart.androidtransitions.scene.samples.bylayoutid

import android.os.Bundle
import android.transition.*
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import kotlinx.android.synthetic.main.activity_content_by_layout_id_scene_sample.*

class ContentByLayoutIdSceneSampleActivity : AbsActivity() {
    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_by_layout_id_scene_sample)

        scene = Scene.getSceneForLayout(rootView, R.layout.layout_scene_sample_content_by_layout_id, this)

        ivBack.setOnClickListener {
            finish()
        }
        ivClearContent.setOnClickListener {
            rootView.removeAllViews()
        }

        btEnterNoAnim.setOnClickListener {
            scene.enter()
        }
        btEnterDefAnim.setOnClickListener {
            TransitionManager.go(scene)
        }
        btEnterCustomAnim.setOnClickListener {
            val imageFadeTransition = Fade().addTarget(R.id.ivSea)
            val textSlideTransition = Slide().addTarget(R.id.tvSea)

            val customAnimTransition = TransitionSet().apply {
                duration = 1000L
                addTransition(imageFadeTransition)
                addTransition(textSlideTransition)
            }

            TransitionManager.go(scene, customAnimTransition)
        }
    }
}
