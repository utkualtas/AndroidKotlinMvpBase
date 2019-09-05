package com.rootylabs.androidkotlinmvpbase.di.component

import android.content.Context
import com.rootylabs.androidkotlinmvpbase.BaseApplication
import com.rootylabs.androidkotlinmvpbase.di.module.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    /*@Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }*/

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<BaseApplication>

}