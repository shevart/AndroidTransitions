package com.shevart.androidtransitions

import android.content.Intent
import android.os.Bundle
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.scene.samples.bylayoutid.ContentByLayoutIdSceneSampleActivity
import com.shevart.androidtransitions.scene.samples.enterexitaction.EnterAndExitActionSceneSampleActivity
import com.shevart.androidtransitions.scene.samples.searchbar.SearchBarSceneSampleActivity
import com.shevart.androidtransitions.util.Launcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btScene.setOnClickListener {
            // todo replace to Launcher
            startActivity(Intent(this, SearchBarSceneSampleActivity::class.java))
            startActivity(Intent(this, ContentByLayoutIdSceneSampleActivity::class.java))
            startActivity(Intent(this, EnterAndExitActionSceneSampleActivity::class.java))
        }
        btTransition.setOnClickListener {
            Launcher.Transition.explodeBoundsTransitionOverview(this)
            Launcher.Transition.changeBoundsArcMotionOverview(this)
            Launcher.Transition.changeBoundsPatternPathMotionOverview(this)
            Launcher.Transition.changeImageTransformOverview(this)
            Launcher.Transition.changeScrollOverview(this)
            Launcher.Transition.autoTransitionOverview(this)
            Launcher.Transition.changeClipBoundsOverview(this)
            Launcher.Transition.fadeTransitionOverview(this)
            Launcher.Transition.changeBoundsTransitionOverview(this)
            Launcher.Transition.slideBoundsTransitionOverview(this)
            Launcher.Transition.changeTransformOverview(this)
            Launcher.Transition.Custom.changeIconImageTransitionOverview(this)
        }
        btTransitionManager.setOnClickListener {
            Launcher.TransitionManager.beginDelayedSample(this)
        }
        btScreenTransitions.setOnClickListener {
            Launcher.ScreenTransitions.menu(this)
        }
        btSpecialCases.setOnClickListener {
            Launcher.SpecialCases.triangleScreens(this)
        }
    }
}
