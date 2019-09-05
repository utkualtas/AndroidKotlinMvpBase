package com.rootylabs.androidkotlinmvpbase.ui.base

interface BaseMvpPresenter<V : BaseMvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

}
