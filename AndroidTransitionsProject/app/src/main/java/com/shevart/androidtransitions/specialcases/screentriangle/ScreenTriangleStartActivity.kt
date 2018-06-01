package com.shevart.androidtransitions.specialcases.screentriangle

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.transition.Transition
import android.support.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.core.view.postDelayed
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity
import com.shevart.androidtransitions.specialcases.screentriangle.fragments.FirstFragment
import com.shevart.androidtransitions.specialcases.screentriangle.fragments.SecondFragment
import com.shevart.androidtransitions.specialcases.screentriangle.middlescreen.MiddleScreensHostActivity
import com.shevart.androidtransitions.util.resultCodeStr
import kotlinx.android.synthetic.main.activity_screen_triangle_start.*

class ScreenTriangleStartActivity : AbsActivity() {
    private val screenChangeDuration = 300L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_triangle_start)
        enableToolbarBackButton()

        if (getCurrentFragment() == null) {
            startContent()
        }

        btTriangleBack.setOnClickListener {
            if (getCurrentFragment() !is FirstFragment) {
                supportFragmentManager.popBackStack()
            }
        }
        btTriangleForvard.setOnClickListener {
            if (getCurrentFragment() !is SecondFragment) {
                showSecondFragment()
            }
        }
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            postponeEnterTransition()
            showSecondFragmentNoStartAnim()

            // todo remove
            btTriangleForvard.postDelayed(500L) {
                startPostponedEnterTransition()
            }
        }
    }

    @SuppressLint("RestrictedApi")
    fun openMiddleActivity(sharedElement: View) {
        val intent = Intent(this, MiddleScreensHostActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, sharedElement, sharedElement.transitionName).toBundle()
        startActivityForResult(intent, 1, options)
    }

    private fun getCurrentFragment() = supportFragmentManager.findFragmentById(R.id.flTriangleContainer)

    private fun startContent() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flTriangleContainer, FirstFragment())
                .commit()
    }

    private fun showSecondFragment() {
        val nextFragment = SecondFragment()
        nextFragment.enterTransition = Slide(Gravity.END).baseSettings(true)
        nextFragment.returnTransition = Slide(Gravity.END).baseSettings()

        val firstFragment = getCurrentFragment()
        firstFragment?.exitTransition = Slide(Gravity.START).baseSettings()
        firstFragment?.reenterTransition = Slide(Gravity.START).baseSettings(true)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTriangleContainer, nextFragment)
                .addToBackStack(null)
                .commit()

    }

    private fun showSecondFragmentNoStartAnim() {
        val nextFragment = SecondFragment()
        nextFragment.enterTransition = null
        nextFragment.returnTransition = Slide(Gravity.END).baseSettings()

        val firstFragment = getCurrentFragment()
        firstFragment?.exitTransition = null
        firstFragment?.reenterTransition = Slide(Gravity.START).baseSettings(true)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTriangleContainer, nextFragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()

    }

    private fun Transition.baseSettings(startDelay: Boolean = false) = this.apply {
        duration = screenChangeDuration
        if (startDelay) {
            this.startDelay = duration / 2
        }
    }
}