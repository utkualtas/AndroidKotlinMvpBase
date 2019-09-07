package com.rootylabs.androidkotlinmvpbase.data.remote

import android.os.Handler
import android.util.Log
import androidx.annotation.MainThread
import androidx.paging.PagedList
import com.rootylabs.androidkotlinmvpbase.data.local.AppDatabase
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import com.rootylabs.androidkotlinmvpbase.utils.PagingRequestHelper
import com.rootylabs.androidkotlinmvpbase.utils.createStatusLiveData
import org.jetbrains.anko.doAsync
import java.util.concurrent.Executor

class PostBoundaryCallback (
    private val ioExecutor: Executor,
    private val appDatabase: AppDatabase
    ): PagedList.BoundaryCallback<Post>(){


    private val helper = PagingRequestHelper(ioExecutor)
    private var networkState = helper.createStatusLiveData()
    private var counter = 100


    /********
    * These all methods executes when there is no data in local database which is dao for our case fatihcim :D
    * This methods triggering multiple times in most cases. So we fixing this problem with PagingRequestHelper class
    * The Android Devs wrote it but not implement yet into the paging lib. So i directly copy the class and add our app.
    * *******/

    @MainThread
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL){
            Log.e("UTKU", "onZeroItemsLoaded")


            /**
             * Firt init if there is no data on dao
             *
             *
             * For example we will make a request to service here.
             * when service success we will use it.recordSuccess() or when an error occurred
             * we will use it.recordFailure(Throwable())
             */
        }
    }

    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: Post) {
        super.onItemAtEndLoaded(itemAtEnd)
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER){
            Log.e("UTKU", "onItemAtEndLoaded")

            /**
             * If the user scroll to bottom end there is no data anymore in dao this method will work
             *
             *
             * For example we will make a request to service here.
             * when service success we will use it.recordSuccess() or when an error occurred
             * we will use it.recordFailure(Throwable())
             */


            val newpost = Post(counter, counter, "NEW DATA RANDOM SEED: $counter","1231231asda")
            val newpost2 = Post(counter + 1, counter + 1, "NEW DATA RANDOM SEED: " + (counter + 1),"1231231asda")
            val newpost3 = Post(counter + 2, counter + 2, "NEW DATA RANDOM SEED: " + (counter + 2),"1231231asda")
            val newpost4 = Post(counter + 3, counter + 3, "NEW DATA RANDOM SEED: " + (counter + 3),"1231231asda")
            val newpost5 = Post(counter + 4, counter + 4, "NEW DATA RANDOM SEED: " + (counter + 4),"1231231asda")
            val list = mutableListOf(newpost, newpost2, newpost3, newpost4, newpost5)

            doAsync {
                appDatabase.postDao().insertAll(list)

            }

            val r = Runnable {
                it.recordSuccess()
            }
            Handler().postDelayed(r, 2000)


            counter += 5


        }
    }

    @MainThread
    override fun onItemAtFrontLoaded(itemAtFront: Post) {
        super.onItemAtFrontLoaded(itemAtFront)
        helper.runIfNotRunning(PagingRequestHelper.RequestType.BEFORE){
            Log.e("UTKU", "onItemAtFrontLoaded")

            /**
             * If the user scroll to top end there is no data anymore in dao this method will work
             * (This method always firing because always there is no data to top)
             *
             *
             * For example we will make a request to service here.
             * when service success we will use it.recordSuccess() or when an error occurred
             * we will use it.recordFailure(Throwable())
             */
        }
    }

}