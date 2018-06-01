package com.shevart.androidtransitions.specialcases.screentriangle.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.specialcases.screentriangle.ScreenTriangleStartActivity
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flTriangleSharedElementA.setOnClickListener {
            (activity as ScreenTriangleStartActivity).openMiddleActivity(flTriangleSharedElementA)
        }
    }
}
