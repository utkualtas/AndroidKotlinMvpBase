package com.rootylabs.androidkotlinmvpbase.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rootylabs.androidkotlinmvpbase.R
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import kotlinx.android.synthetic.main.item_test.view.*


class TestAdapter(context: Context) : PagedListAdapter<Post, TestAdapter.ViewHolder>(diffCallback) {


    private val context: Context = context


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_test, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.text = getItem(position)?.title
        holder.itemView.body.text = getItem(position)?.body
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}