package com.shevart.androidtransitions.scene.samples.enterexitaction

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Scene
import android.transition.TransitionManager
import android.view.View
import com.shevart.androidtransitions.R
import kotlinx.android.synthetic.main.activity_enter_and_exit_action_scene_sample.*

class EnterAndExitActionSceneSampleActivity : AppCompatActivity() {
    private lateinit var logoScene: Scene
    private lateinit var loginScene: Scene
    private lateinit var registerScene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_and_exit_action_scene_sample)

        logoScene = Scene(rootView)
        logoScene.setEnterAction { logoLayout.visibility = View.VISIBLE }
        logoScene.setExitAction { logoLayout.visibility = View.GONE }

        // apply logo scene
        TransitionManager.go(logoScene, getLogoStartAnimation())

        loginScene = Scene(rootView)
        loginScene.setEnterAction { loginLayout.visibility = View.VISIBLE }
        loginScene.setExitAction { loginLayout.visibility = View.GONE }

        registerScene = Scene(rootView)
        registerScene.setEnterAction { registerLayout.visibility = View.VISIBLE }
        registerScene.setExitAction { registerLayout.visibility = View.GONE }

        btLogin.setOnClickListener {
            TransitionManager.go(loginScene)
        }
        btRegister.setOnClickListener {
            TransitionManager.go(registerScene)
        }
    }

    private fun getLogoStartAnimation() = Fade().apply {
        duration = 1000L // 1 sec
        startDelay = 500L // 0.5 sec
    }
}
