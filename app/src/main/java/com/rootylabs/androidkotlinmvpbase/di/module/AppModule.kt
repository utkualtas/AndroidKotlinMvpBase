package com.rootylabs.androidkotlinmvpbase.di.module

import android.content.Context
import androidx.room.Room
import com.rootylabs.androidkotlinmvpbase.BaseApplication
import com.rootylabs.androidkotlinmvpbase.data.DataManager
import com.rootylabs.androidkotlinmvpbase.data.MainDataManager
import com.rootylabs.androidkotlinmvpbase.data.local.AppDatabase
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpPresenter
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpView
import com.rootylabs.androidkotlinmvpbase.ui.base.BasePresenter
import dagger.Module
import dagger.Provides

@Module
class AppModule{

    @Provides
    fun provideBasePresenter(basePresenter: BasePresenter<BaseMvpView>): BaseMvpPresenter<BaseMvpView> = basePresenter

    @Provides
    fun provideContext(app: BaseApplication): Context = app

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideDataManager(dataManager: MainDataManager): DataManager = dataManager
}