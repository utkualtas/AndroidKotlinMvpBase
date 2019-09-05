package com.rootylabs.androidkotlinmvpbase.ui

import android.os.Bundle
import com.rootylabs.androidkotlinmvpbase.R
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseActivity


class MainActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main)

    }


}