package com.rootylabs.androidkotlinmvpbase.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rootylabs.androidkotlinmvpbase.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class MainActivity : BaseActivity(){

    @Inject lateinit var test: Test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main)


        Log.e("Utku", test.getText())


    }


}