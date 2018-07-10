package com.shevart.androidtransitions.util

import android.content.Context
import android.graphics.Matrix
import android.graphics.RectF
import android.os.Parcelable
import android.support.v4.app.SharedElementCallback
import android.util.Log
import android.view.View

fun createDevLogSharedElementCallback(transitionType: String, screenName: String) = object : SharedElementCallback() {
    override fun onCaptureSharedElementSnapshot(sharedElement: View?,
                                                viewToGlobalMatrix: Matrix?,
                                                screenBounds: RectF?): Parcelable {
        logMsg(transitionType, screenName, "onCaptureSharedElementSnapshot()")
        return super.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds)
    }

    override fun onCreateSnapshotView(context: Context?, snapshot: Parcelable?): View {
        logMsg(transitionType, screenName, "onCreateSnapshotView()")
        return super.onCreateSnapshotView(context, snapshot)
    }

    override fun onMapSharedElements(names: MutableList<String>?,
                                     sharedElements: MutableMap<String, View>?) {
        super.onMapSharedElements(names, sharedElements)
        logMsg(transitionType, screenName, "onMapSharedElements()")
    }

    override fun onRejectSharedElements(rejectedSharedElements: MutableList<View>?) {
        super.onRejectSharedElements(rejectedSharedElements)
        logMsg(transitionType, screenName, "onRejectSharedElements()")
    }

    override fun onSharedElementEnd(sharedElementNames: MutableList<String>?,
                                    sharedElements: MutableList<View>?,
                                    sharedElementSnapshots: MutableList<View>?) {
        super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
        logMsg(transitionType, screenName, "onSharedElementEnd()")
    }

    override fun onSharedElementStart(sharedElementNames: MutableList<String>?,
                                      sharedElements: MutableList<View>?,
                                      sharedElementSnapshots: MutableList<View>?) {
        super.onSharedElementStart(sharedElementNames, sharedElements, sharedElementSnapshots)
        logMsg(transitionType, screenName, "onSharedElementStart()")
    }

    override fun onSharedElementsArrived(sharedElementNames: MutableList<String>?,
                                         sharedElements: MutableList<View>?,
                                         listener: OnSharedElementsReadyListener?) {
        super.onSharedElementsArrived(sharedElementNames, sharedElements, listener)
        logMsg(transitionType, screenName, "onSharedElementsArrived()")
    }
}

private fun logMsg(transitionType: String, screenName: String, msg: String) {
    Log.e("SHARED_ELEM_CALLBACK", "Event: $transitionType, Screen=$screenName, msg=$msg")
}