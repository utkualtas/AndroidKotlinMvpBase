package com.rootylabs.androidkotlinmvpbase.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.rootylabs.androidkotlinmvpbase.data.local.AppDatabase
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import com.rootylabs.androidkotlinmvpbase.data.remote.services.PostService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import java.util.concurrent.Executors
import javax.inject.Inject


class PostRepository @Inject constructor(): PostDataSource, PageKeyedDataSource<Int, Post>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Post>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        Log.e("UTKU", "loadBefore")
    }


    @Inject lateinit var postService: PostService
    @Inject lateinit var mAppDatabase: AppDatabase

    /*override fun getPosts(): LiveData<List<Post>> {
        *//*return postService!!.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { t -> {

            } }*//*


    }*/

    override fun getPosts(): LiveData<PagedList<Post>> {
        postService.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("UTKU", "Data came from server.")
                doAsync {
                    var result = mAppDatabase.postDao().insertAll(it)
                }

            }, {
                Log.e("UTKU", "An error occurred. " + it.toString())
            })

        //Log.e("UTKU", mAppDatabase.postDao().loadAllPosts().value?.size.toString())

       /* val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                val myList: MutableList<Post> = mutableListOf()
                val randomSeed = Random().nextInt(50 - 1) + 1
                val newpost:Post = Post(randomSeed, randomSeed, "asdasda RANDOM SEED: $randomSeed","1231231asda")
                myList.add(newpost)
                doAsync {
                    mAppDatabase.postDao().insert(post = newpost)
                }
                mainHandler.postDelayed(this, 1000)
            }
        })*/
        val dataSourceFactory = mAppDatabase.postDao().loadAllPosts()
        return LivePagedListBuilder(dataSourceFactory, Config(pageSize = 10, enablePlaceholders = true, maxSize = 30))
            .setBoundaryCallback(PostBoundaryCallback(Executors.newSingleThreadExecutor(), mAppDatabase))
            .build()


    }

}