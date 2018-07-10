@file:Suppress("unused")

package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base

interface BasePresenter<V: BaseView> {
    fun attachView(view: V)

    fun detachView()
}

interface BaseView