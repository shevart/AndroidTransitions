package com.shevart.androidtransitions

import android.content.Intent
import android.os.Bundle
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.scene.samples.bylayoutid.ContentByLayoutIdSceneSampleActivity
import com.shevart.androidtransitions.scene.samples.searchbar.SearchBarSceneSampleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btScene.setOnClickListener {
            startActivity(Intent(this, SearchBarSceneSampleActivity::class.java))
            startActivity(Intent(this, ContentByLayoutIdSceneSampleActivity::class.java))
        }
    }
}
