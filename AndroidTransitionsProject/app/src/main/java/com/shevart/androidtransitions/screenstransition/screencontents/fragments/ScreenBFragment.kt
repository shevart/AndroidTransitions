package com.shevart.androidtransitions.screenstransition.screencontents.fragments

import android.os.Bundle
import android.view.View
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsFragment

class ScreenBFragment : AbsFragment() {
    override fun provideLayoutResId() = R.layout.fragment_screen_b

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
