package com.shevart.androidtransitions.advanced.clean.code.delegates

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity

class CleanCodeDelegateTransitionActivity : AbsActivity(),
        ContentTransitionProvider by SimpleContentTransitionDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentTransitionByDelegate(this)
        setContentView(R.layout.activity_clean_code_delegate_transition)
    }
}