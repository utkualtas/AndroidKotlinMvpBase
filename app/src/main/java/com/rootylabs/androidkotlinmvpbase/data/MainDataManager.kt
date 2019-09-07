package com.rootylabs.androidkotlinmvpbase.data

import com.rootylabs.androidkotlinmvpbase.data.remote.PostDataSource
import javax.inject.Inject

class MainDataManager @Inject constructor(): DataManager{

    @Inject lateinit var postDataSource: PostDataSource

    override fun getPostService(): PostDataSource = postDataSource



}