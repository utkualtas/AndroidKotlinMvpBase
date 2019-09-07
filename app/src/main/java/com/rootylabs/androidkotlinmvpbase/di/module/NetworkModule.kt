package com.rootylabs.androidkotlinmvpbase.di.module

import android.content.Context
import com.rootylabs.androidkotlinmvpbase.BuildConfig
import com.rootylabs.androidkotlinmvpbase.data.remote.PostDataSource
import com.rootylabs.androidkotlinmvpbase.data.remote.PostRepository
import com.rootylabs.androidkotlinmvpbase.data.remote.services.PostService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class NetworkModule {

    @Provides
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(
        PostService::class.java)

    @Provides
    fun provideRetrofitClient(context: Context): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()


        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    }


    @Provides
    fun providePostDataSource(postRepository: PostRepository): PostDataSource = postRepository


}