package com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp

import android.os.Bundle
import android.support.transition.Transition
import android.support.v7.widget.LinearLayoutManager
import android.transition.Explode
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import androidx.core.view.doOnPreDraw
import androidx.core.view.postDelayed
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.advanced.mvpandmvvmpatterns.mvp.base.AbsMvpTransitionActivity
import com.shevart.androidtransitions.common.MockSimpleItemAdapter
import com.shevart.androidtransitions.common.SimpleItem
import com.shevart.androidtransitions.util.nextSimpleItemsList
import kotlinx.android.synthetic.main.activity_mvp_transition_sample.*

class MvpTransitionSampleActivity : AbsMvpTransitionActivity<SampleTransitionContract.Presenter,
        SampleTransitionContract.View>(), SampleTransitionContract.View {
    override fun provideView() = this

    override fun providePresenter() = Presenter()

    override fun displayData(items: List<SimpleItem>) {
        (rvSimpleItems.adapter as? MockSimpleItemAdapter)?.updateItems(items)
        rvSimpleItems.doOnPreDraw {
            it.postDelayed(55) { startPostponedEnterTransition() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_transition_sample)

        postponeEnterTransition()
        flSampleMvpTransitionRoot.transitionName = getString(R.string.sample_root_transition_name)
        rvSimpleItems.layoutManager = LinearLayoutManager(this)
        rvSimpleItems.adapter = MockSimpleItemAdapter()

        presenter.loadData()
    }
}