package com.rootylabs.androidkotlinmvpbase

import android.app.Application
import com.rootylabs.androidkotlinmvpbase.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class BaseApplication: DaggerApplication(), HasAndroidInjector {


    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}