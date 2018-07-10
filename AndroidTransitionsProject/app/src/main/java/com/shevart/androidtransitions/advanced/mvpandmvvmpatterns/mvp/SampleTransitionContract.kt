package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp

import com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base.BasePresenter
import com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base.BaseView
import com.shevart.androidtransitions.common.SimpleItem

interface SampleTransitionContract {
    interface View: BaseView {
        fun displayData(items: List<SimpleItem>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadData()
    }
}