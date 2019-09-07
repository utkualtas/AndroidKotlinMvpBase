package com.rootylabs.androidkotlinmvpbase.ui

import androidx.lifecycle.MutableLiveData
import com.rootylabs.androidkotlinmvpbase.data.model.Post
import com.rootylabs.androidkotlinmvpbase.ui.base.BasePresenter
import javax.inject.Inject




class MainActivityPresenter<V : MainActivityContract.View>
@Inject constructor() : BasePresenter<V>(),
    MainActivityContract.Presenter<V> {

    var posts: MutableLiveData<List<Post>>? = null

    init {
        posts = MutableLiveData()
    }


    override fun getContent() {


        getMvpView()!!.setContent(getDataManager()!!.getPostService().getPosts())




    }

}