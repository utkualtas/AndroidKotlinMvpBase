package com.rootylabs.androidkotlinmvpbase.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseActivity
import kotlinx.android.synthetic.main.acitivity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainActivityContract.View {


    @Inject
    lateinit var mPresenter:MainActivityPresenter<MainActivityContract.View>
    private lateinit var adapter: TestAdapter
    private var mPosts: List<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rootylabs.androidkotlinmvpbase.R.layout.acitivity_main)
        mPresenter.onAttach(this)

        adapter = TestAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        mPresenter.getContent()
    }


    override fun setContent(listContent: LiveData<PagedList<Post>>) {
        val observer = Observer<PagedList<Post>> {
            Log.e("Utku", "Oberver Working")
            adapter.submitList(it)
        }
        listContent.observe(this, observer)



    }

}