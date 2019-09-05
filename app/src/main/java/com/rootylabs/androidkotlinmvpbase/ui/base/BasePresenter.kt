package com.rootylabs.androidkotlinmvpbase.ui.base

import javax.inject.Inject

class BasePresenter<V: BaseMvpView> @Inject constructor() : BaseMvpPresenter<V> {

    private var mMvpView:V? = null


    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    override fun onDetach() {
        mMvpView = null
    }

    fun getMvpView():V? = mMvpView
}