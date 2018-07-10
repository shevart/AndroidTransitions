package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base

abstract class AbsPresenter<V: BaseView>: BasePresenter<V> {
    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
        onViewAttached(view)
    }

    override fun detachView() {
        view = null
        onViewDetached()
    }

    protected open fun onViewAttached(view: V) {}

    protected open fun onViewDetached() {}
}