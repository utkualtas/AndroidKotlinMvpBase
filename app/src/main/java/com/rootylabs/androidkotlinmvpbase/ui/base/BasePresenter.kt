package com.rootylabs.androidkotlinmvpbase.ui.base

import com.rootylabs.androidkotlinmvpbase.data.DataManager
import javax.inject.Inject

open class BasePresenter<V: BaseMvpView> @Inject constructor() : BaseMvpPresenter<V> {

    @Inject lateinit var mDataManager: DataManager

    private var mMvpView:V? = null


    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    override fun onDetach() {
        mMvpView = null
    }

    fun getMvpView():V? = mMvpView

    fun getDataManager(): DataManager? = mDataManager
}