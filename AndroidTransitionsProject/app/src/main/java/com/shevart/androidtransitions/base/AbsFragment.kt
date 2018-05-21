package com.shevart.androidtransitions.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shevart.androidtransitions.R

abstract class AbsFragment : Fragment() {

    @LayoutRes
    protected abstract fun provideLayoutResId(): Int

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                    savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayoutResId(), container, false)
    }
}
