package com.rootylabs.androidkotlinmvpbase.di.module

import com.rootylabs.androidkotlinmvpbase.ui.MainActivity
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity
}