package com.rootylabs.androidkotlinmvpbase.di.module

import com.rootylabs.androidkotlinmvpbase.ui.BaseActivity
import com.rootylabs.androidkotlinmvpbase.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}