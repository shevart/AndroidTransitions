package com.shevart.androidtransitions.advanced.clean.code

import android.os.Bundle
import com.shevart.androidtransitions.R
import com.shevart.androidtransitions.base.AbsActivity

class CleanCodeTransitionActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentTransition()
        initSharedElementsTransition()
        setContentView(R.layout.activity_clean_code_transition)
    }
}
