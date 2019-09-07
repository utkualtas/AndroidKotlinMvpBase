package com.rootylabs.androidkotlinmvpbase.data.remote.services

import com.rootylabs.androidkotlinmvpbase.data.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    fun getAllPosts(): Observable<List<Post>>

    @GET("/posts")
    fun getOnePosts(): Observable<List<Post>>

    @GET("/posts")
    fun getLastPosts(): Observable<List<Post>>
}