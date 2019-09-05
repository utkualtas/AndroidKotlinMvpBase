package com.rootylabs.androidkotlinmvpbase.di.component

import com.rootylabs.androidkotlinmvpbase.BaseApplication
import com.rootylabs.androidkotlinmvpbase.di.module.ActivityBuilderModule
import com.rootylabs.androidkotlinmvpbase.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    /*@Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }*/

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<BaseApplication>

}