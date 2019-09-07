package com.rootylabs.androidkotlinmvpbase.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "posts")
data class Post(var userId: Int, @PrimaryKey @NonNull @ColumnInfo(name = "post") var id: Int, var title: String, var body: String) : Serializable