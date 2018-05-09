package com.shevart.androidtransitions

import android.content.Intent
import android.os.Bundle
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.scene.samples.bylayoutid.ContentByLayoutIdSceneSampleActivity
import com.shevart.androidtransitions.scene.samples.enterexitaction.EnterAndExitActionSceneSampleActivity
import com.shevart.androidtransitions.scene.samples.searchbar.SearchBarSceneSampleActivity
import com.shevart.androidtransitions.transition.overview.TransitionsOverviewComplexLayoutActivity
import com.shevart.androidtransitions.transition.overview.base.ChangeBoundsOverviewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btScene.setOnClickListener {
            startActivity(Intent(this, SearchBarSceneSampleActivity::class.java))
            startActivity(Intent(this, ContentByLayoutIdSceneSampleActivity::class.java))
            startActivity(Intent(this, EnterAndExitActionSceneSampleActivity::class.java))
        }

        btTransition.setOnClickListener {
            startActivity(Intent(this, TransitionsOverviewComplexLayoutActivity::class.java))
            startActivity(Intent(this, ChangeBoundsOverviewActivity::class.java))
        }
    }
}
