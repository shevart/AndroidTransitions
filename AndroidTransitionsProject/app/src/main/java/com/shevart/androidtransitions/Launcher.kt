package com.shevart.androidtransitions

import android.app.Activity
import android.content.Intent
import com.shevart.androidtransitions.transition.overview.base.*

object Launcher {
    fun fadeTransitionOverview(activity: Activity) {
        activity.startActivity(Intent(activity, FadeOverviewActivity::class.java))
    }

    fun changeBoundsTransitionOverview(activity: Activity) {
        activity.startActivity(Intent(activity, ChangeBoundsOverviewActivity::class.java))
    }

    fun slideBoundsTransitionOverview(activity: Activity) {
        activity.startActivity(Intent(activity, SlideOverviewActivity::class.java))
    }

    fun explodeBoundsTransitionOverview(activity: Activity) {
        activity.startActivity(Intent(activity, ExplodeOverviewActivity::class.java))
    }

    fun changeBoundsArcMotionOverview(activity: Activity) {
        activity.startActivity(Intent(activity, ChangeBoundsWithPathMotionOverviewActivity::class.java))
    }
}
