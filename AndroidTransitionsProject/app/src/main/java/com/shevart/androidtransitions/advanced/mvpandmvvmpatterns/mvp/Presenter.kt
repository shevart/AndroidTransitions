package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp

import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base.AbsPresenter
import com.shevart.androidtransitions.util.nextSimpleItemsList

class Presenter : AbsPresenter<SampleTransitionContract.View>(), SampleTransitionContract.Presenter {
    private val handler = Handler(Looper.getMainLooper())

    override fun loadData() {
        // remove old requests
        handler.removeCallbacksAndMessages(null)
        // mock data loading
        handler.postDelayed(delayInMillis = 500) {
            view?.displayData(nextSimpleItemsList())
        }
    }
}