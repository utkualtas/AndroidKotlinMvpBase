package com.rootylabs.androidkotlinmvpbase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rootylabs.androidkotlinmvpbase.data.model.Post


@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun postDao(): PostDao
}