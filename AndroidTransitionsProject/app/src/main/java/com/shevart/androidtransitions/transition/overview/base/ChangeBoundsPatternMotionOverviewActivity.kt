package com.shevart.androidtransitions.transition.overview.base

import android.graphics.Path
import android.support.transition.ChangeBounds
import android.support.transition.PatternPathMotion
import android.support.transition.Transition
import com.shevart.androidtransitions.R

class ChangeBoundsPatternMotionOverviewActivity : AbsTransitionBaseActivity() {
    override fun provideIcon() = R.drawable.change_bounds_pattern_path_motion

    override fun provideTitle() = getString(R.string.change_bounds_plus_pattern_path_motion)!!

    override fun provideTransition(): Transition {
        val path = createPath()
        return ChangeBounds().apply {
            setPathMotion(PatternPathMotion(path))
        }
    }

    /**
     * Create Path with custom motion for transition
     * Something like:
     * Start
     * -----------
     *          /
     *         /
     *        /
     *       /
     *      /
     *     /___________ End
     *
     */
    private fun createPath() = Path().apply {
        moveTo(0f,0f)
        quadTo(0f,0f, 1f, 0.3f)
        quadTo(1f,0.3f, 0.3f, 0.6f)
        quadTo(0.3f,0.6f, 1f, 1f)
    }
}
