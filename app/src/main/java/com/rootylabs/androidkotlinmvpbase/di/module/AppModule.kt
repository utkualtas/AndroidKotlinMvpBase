package com.rootylabs.androidkotlinmvpbase.di.module

import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpPresenter
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpView
import com.rootylabs.androidkotlinmvpbase.ui.base.BasePresenter
import dagger.Module
import dagger.Provides

@Module
class AppModule{

    @Provides
    fun provideBasePresenter(basePresenter: BasePresenter<BaseMvpView>): BaseMvpPresenter<BaseMvpView> = basePresenter

}