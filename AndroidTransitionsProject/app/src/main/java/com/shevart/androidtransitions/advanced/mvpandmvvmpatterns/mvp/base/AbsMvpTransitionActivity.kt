package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base

import android.os.Bundle
import com.shevart.androidtransitions.advanced.clean.code.initContentTransition
import com.shevart.androidtransitions.advanced.clean.code.initSharedElementsTransition
import com.shevart.androidtransitions.base.AbsActivity

abstract class AbsMvpTransitionActivity<P: BasePresenter<V>, V: BaseView> : AbsActivity() {
    protected lateinit var presenter: P

    protected abstract fun provideView(): V

    protected abstract fun providePresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        initSharedElementsTransition()
        super.onCreate(savedInstanceState)
        presenter = providePresenter()
        presenter.attachView(provideView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}