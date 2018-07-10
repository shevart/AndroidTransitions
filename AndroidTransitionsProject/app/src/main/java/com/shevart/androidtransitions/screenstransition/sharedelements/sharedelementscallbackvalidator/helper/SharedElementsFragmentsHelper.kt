package com.shevart.androidtransitions.screenstransition.sharedelements.sharedelementscallbackvalidator.helper

import android.support.v4.app.Fragment
import android.support.v4.app.SharedElementCallback
import android.util.Log
import android.view.View

@Suppress("unused")
class SharedElementsFragmentsHelper {
    private val records = HashMap<String, FragmentSharedElementsTransition>()

    fun validateSharedElementsScreenTransition(screenTransitionName: String,
                                               fragmentFrom: Fragment,
                                               fragmentTo: Fragment): Boolean {
        if (records[screenTransitionName] != null) {
            return false
        }

        records[screenTransitionName] = FragmentSharedElementsTransition(screenTransitionName,
                null, null)

        val exitCallback = object : SharedElementCallback() {
            override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                validateTransitionNamesDuplicates(fragmentFrom, SCREEN_A)
                validateSharedElementsViewState2(names, sharedElements, fragmentFrom.view!!, SCREEN_A)
                records[screenTransitionName]?.screenRecordA = createTransitionRecord(names)
                fragmentFrom.setExitSharedElementCallback(null)
            }
        }
        fragmentFrom.setExitSharedElementCallback(exitCallback)

        val enterCallback = object : SharedElementCallback() {
            override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                validateTransitionNamesDuplicates(fragmentTo, SCREEN_B)
                validateSharedElementsViewState2(names, sharedElements, fragmentTo.view!!, SCREEN_B)
                records[screenTransitionName]?.screenRecordB = createTransitionRecord(names)
                checkIsValidFragmentTransition(records[screenTransitionName]!!)

                fragmentTo.setEnterSharedElementCallback(null)
            }
        }
        val returnCallback = object : SharedElementCallback() {
            override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                Log.e("T", names?.joinToString() ?: "no names")
            }

            override fun onSharedElementEnd(sharedElementNames: MutableList<String>?, sharedElements: MutableList<View>?, sharedElementSnapshots: MutableList<View>?) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
                Log.e("T", sharedElementNames?.joinToString() ?: "no names")
            }
        }
        fragmentTo.setEnterSharedElementCallback(enterCallback)
        fragmentTo.setExitSharedElementCallback(returnCallback)

        // ???
        fragmentFrom.setEnterSharedElementCallback(returnCallback)

        return true
    }

    // print all duplicates in the future!
    private fun validateTransitionNamesDuplicates(fragment: Fragment, screenName: String) {
        if (fragment.view != null) {
            val duplicatesExists = checkIsTransitionNamesDuplicatesExists(view = fragment.view!!)
            if (duplicatesExists) {
                throw IllegalStateException("There are views with the same transitionName on the $screenName")
            }
        }
    }

    private fun validateSharedElementsViewState(names: MutableList<String>?,
                                                sharedElements: MutableMap<String, View>?,
                                                screenName: String) {
        if (names == null || sharedElements == null) {
            return
        }

        if (!checkIsAllViewsExists(names, sharedElements)) {
            throwTransitionNamesWithoutViewsException(names, sharedElements, screenName)
        }
    }

    fun validateSharedElementsViewState2(names: MutableList<String>?,
                                        sharedElements: MutableMap<String, View>?,
                                        fragmentView: View,
                                        screenName: String) {
        if (names == null || sharedElements == null) {
            return
        }

        if (!checkIsAllViewsMeasured(names, fragmentView)) {
            throw IllegalStateException("Your views still now measured on the $screenName. " +
                    "Try to use \"postponeEnterTransition()\" in onViewCreated() and then after your" +
                    " view will be measured call \"startPostponedEnterTransition()\"")
        }
        if (!checkIsAllViewsExists(names, sharedElements)) {
            throwTransitionNamesWithoutViewsException(names, sharedElements, screenName)
        }
    }

    private fun createTransitionRecord(names: MutableList<String>?): FragmentSharedElementsTransitionRecord {
        val record = FragmentSharedElementsTransitionRecord(names?.toSet() ?: emptySet())
        if (record.viewNames.size != (names?.size ?: 0)) {
            throw IllegalStateException("There is no transition names in FragmentA!")
        }
        return record
    }

    private fun checkIsValidFragmentTransition(transition: FragmentSharedElementsTransition) {
        if (transition.screenRecordA == null || transition.screenRecordB == null) {
            throw IllegalStateException("Check it!")
        }

        val namesScreenA = transition.screenRecordA!!.viewNames
        val namesScreenB = transition.screenRecordA!!.viewNames

        val nonPairedElementsTransitionNamesA = ArrayList<String>()
        val nonPairedElementsTransitionNamesB = ArrayList<String>()
        namesScreenA.forEach {
            if (!namesScreenB.contains(it)) {
                nonPairedElementsTransitionNamesA.add(it)
            }
        }
        namesScreenB.forEach {
            if (!namesScreenA.contains(it)) {
                nonPairedElementsTransitionNamesB.add(it)
            }
        }
        if (nonPairedElementsTransitionNamesA.isNotEmpty()) {
            throw IllegalStateException("In fragment B this transitionNames not found: ${nonPairedElementsTransitionNamesA.joinToString()}")
        }
        if (nonPairedElementsTransitionNamesB.isNotEmpty()) {
            throw IllegalStateException("In fragment A this transitionNames not found: ${nonPairedElementsTransitionNamesB.joinToString()}")
        }

        records.remove(transition.screenTransitionName)
    }

    private fun validateSharedElementsTransition(transition: Any?) {

    }

    companion object {
        const val SCREEN_A = "ScreenA"
        const val SCREEN_B = "ScreenB"
    }
}