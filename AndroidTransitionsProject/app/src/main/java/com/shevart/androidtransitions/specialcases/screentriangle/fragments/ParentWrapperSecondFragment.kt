package com.shevart.androidtransitions.specialcases.screentriangle.fragments

import android.os.Bundle
import android.support.transition.TransitionInflater
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shevart.androidtransitions.R

class ParentWrapperSecondFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater
                .from(context)
                .inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_parent_wrapper_second, container, false)
    }

    @Suppress("ReplaceSingleLineLet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.let { fm ->
            fm
                    .beginTransaction()
                    .add(R.id.flParentWrapperSecondContainer, SecondFragment())
                    .commitAllowingStateLoss()
        }
    }
}