package com.shevart.androidtransitions.util

import android.app.Activity
import android.content.Intent
import com.shevart.androidtransitions.screenstransition.ScreenTransitionsTopicActivity
import com.shevart.androidtransitions.screenstransition.screencontents.activity.bytheme.ContentTransitionByThemeScreenAActivity
import com.shevart.androidtransitions.screenstransition.screencontents.activity.programmatically.FirstContentProgrammaticallyActivity
import com.shevart.androidtransitions.screenstransition.screencontents.fragments.FragmentsScreenContentTransitionActivity
import com.shevart.androidtransitions.screenstransition.sharedelements.activity.SharedElementsAActivity
import com.shevart.androidtransitions.screenstransition.sharedelements.fragments.FragmentsSharedElementsActivity
import com.shevart.androidtransitions.specialcases.screentriangle.ScreenTriangleStartActivity
import com.shevart.androidtransitions.transition.overview.base.*
import com.shevart.androidtransitions.transition.overview.custom.ChangeIconImageTransitionActivity
import com.shevart.androidtransitions.transitionmanager.begindelayedsample.BeginDelayedSampleActivity

// todo sort methods
object Launcher {
    object Transition {
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
            activity.startActivity(Intent(activity, ChangeBoundsArcMotionOverviewActivity::class.java))
        }

        fun changeBoundsPatternPathMotionOverview(activity: Activity) {
            activity.startActivity(Intent(activity, ChangeBoundsPatternMotionOverviewActivity::class.java))
        }

        fun changeTransformOverview(activity: Activity) {
            activity.startActivity(Intent(activity, ChangeTransformOverviewActivity::class.java))
        }

        fun changeImageTransformOverview(activity: Activity) {
            activity.startActivity(Intent(activity, ChangeImageTransformOverviewActivity::class.java))
        }

        fun changeScrollOverview(activity: Activity) {
            activity.startActivity(Intent(activity, ChangeScrollOverviewActivity::class.java))
        }

        fun changeClipBoundsOverview(activity: Activity) {
            activity.startActivity(Intent(activity, ChangeClipBoundsActivity::class.java))
        }

        fun autoTransitionOverview(activity: Activity) {
            activity.startActivity(Intent(activity, AutoTransitionOverviewActivity::class.java))
        }

        object Custom {
            fun changeIconImageTransitionOverview(activity: Activity) {
                activity.startActivity(Intent(activity, ChangeIconImageTransitionActivity::class.java))
            }
        }
    }

    object TransitionManager {
        fun beginDelayedSample(activity: Activity) {
            activity.startActivity(Intent(activity, BeginDelayedSampleActivity::class.java))
        }
    }

    object ScreenTransitions {
        fun menu(activity: Activity) {
            activity.startActivity(Intent(activity, ScreenTransitionsTopicActivity::class.java))
        }

        object Content {
            fun fragmentsSample(activity: Activity) {
                activity.startActivity(Intent(activity, FragmentsScreenContentTransitionActivity::class.java))
            }

            fun activitySampleByTheme(activity: Activity) {
                activity.startActivity(Intent(activity, ContentTransitionByThemeScreenAActivity::class.java))
            }

            fun activitySampleProgrammatically(activity: Activity) {
                activity.startActivity(Intent(activity, FirstContentProgrammaticallyActivity::class.java))
            }
        }

        object SharedElements {
            fun fragment(activity: Activity) {
                activity.startActivity(Intent(activity, FragmentsSharedElementsActivity::class.java))
            }

            fun activityByTheme(activity: Activity) {
                activity.startActivity(Intent(activity, SharedElementsAActivity::class.java))
            }
        }
    }

    object SpecialCases {
        fun triangleScreens(activity: Activity) {
            activity.startActivity(Intent(activity, ScreenTriangleStartActivity::class.java))
        }
    }
}
