package com.rootylabs.androidkotlinmvpbase.data.local

import androidx.paging.DataSource
import androidx.room.*
import com.rootylabs.androidkotlinmvpbase.data.model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Post>)

    @Update
    fun update(post: Post)

    @Delete
    fun delete(post: Post)

    @Query("SELECT * from Posts ORDER BY post  ASC")
    fun loadAllPosts(): DataSource.Factory<Int, Post>
}