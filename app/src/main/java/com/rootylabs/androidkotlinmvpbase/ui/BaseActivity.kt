package com.rootylabs.androidkotlinmvpbase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rootylabs.androidkotlinmvpbase.di.component.AppComponent
import com.rootylabs.androidkotlinmvpbase.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}