package com.rootylabs.androidkotlinmvpbase

import com.rootylabs.androidkotlinmvpbase.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector


class BaseApplication: DaggerApplication(), HasAndroidInjector {


    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}