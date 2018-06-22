package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallback.helper

import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get

fun throwTransitionNamesWithoutViewsException(names: List<String>,
                                              sharedElements: Map<String, View>,
                                              screenName: String): Nothing {
    val transitionNamesWithoutViews = names
            .filter { sharedElements[it] == null }
            .joinToString()

    throw IllegalStateException("There are transitionNames without views on the screen " +
            "\"$screenName\". TransitionNames: $transitionNamesWithoutViews. ")
}

fun checkIsAllViewsExists(names: List<String>,
                          sharedElements: Map<String, View>): Boolean {
    names.forEach { transitionName ->
        if (sharedElements[transitionName] == null) {
            return false
        }
    }
    return true
}

// skip if view not found
fun checkIsAllViewsMeasured(names: List<String>,
                            fragmentView: View): Boolean {
    names.forEach { transitionName ->
        val view = fragmentView.findViewByTransitionName(transitionName)
        if (view != null) {
            if (view.width == 0 || view.height == 0) {
                return false
            }
        }
    }
    return true
}

fun checkIsTransitionNamesDuplicatesExists(view: View): Boolean {
    val allTransitionNames = view.findAllTransitionNames()
    val allUniqueTransitionNames = allTransitionNames.toSet()
    return allTransitionNames.size != allUniqueTransitionNames.size
}

fun Fragment.validateSharedElementsTransition(forceCheckTransition: Boolean = false) {
    val fragmentName = this::class.java.simpleName
    if (this.sharedElementEnterTransition == null) {
        throw IllegalStateException("There is no sharedElementEnterTransition in fragment $fragmentName")
    }
    if (forceCheckTransition &&
            !this.isChangeBoundsExists() && !this.isSupportChangeBoundsExists()) {
        throwThereIsNoChangeBounds(fragmentName)
    }
}

private fun View.findAllTransitionNames(): List<String> {
    val result = ArrayList<String>()
    if (!this.transitionName.isNullOrBlank()) {
        result.add(this.transitionName)
    }
    if (this is ViewGroup) {
        for (i in 0 until this.childCount) {
            result.addAll(this[i].findAllTransitionNames())
        }
    }

    return result
}

private fun View.findViewByTransitionName(transitionName: String): View? {
    if (this.transitionName == transitionName) {
        return this
    }
    if (this is ViewGroup) {
        for (i in 0 until this.childCount) {
            val result = this[i].findViewByTransitionName(transitionName)
            if (result != null) {
                return result
            }
        }
    }

    return null
}

private fun throwThereIsNoChangeBounds(fragmentName: String) {
    throw IllegalStateException("There is no ChangeBounds transition " +
            "in your $fragmentName.sharedElementEnterTransition!")
}