package com.rootylabs.androidkotlinmvpbase.ui

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpPresenter
import com.rootylabs.androidkotlinmvpbase.ui.base.BaseMvpView

class MainActivityContract{


    interface View: BaseMvpView {
        fun setContent(listContent : LiveData<PagedList<Post>>)
    }


    interface Presenter<V: View>:
        BaseMvpPresenter<V> {
        fun getContent()
    }



}