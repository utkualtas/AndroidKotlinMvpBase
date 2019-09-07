package com.rootylabs.androidkotlinmvpbase.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.rootylabs.androidkotlinmvpbase.data.model.Post

interface PostDataSource {

    fun getPosts(): LiveData<PagedList<Post>>
}