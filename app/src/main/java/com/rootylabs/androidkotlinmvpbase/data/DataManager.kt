package com.rootylabs.androidkotlinmvpbase.data

import com.rootylabs.androidkotlinmvpbase.data.remote.PostDataSource

interface DataManager {
    fun getPostService(): PostDataSource
}