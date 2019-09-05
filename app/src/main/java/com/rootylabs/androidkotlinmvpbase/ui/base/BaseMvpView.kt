package com.rootylabs.androidkotlinmvpbase.ui.base

interface BaseMvpView {

    fun showLoading()

    fun hideLoading()

    fun showSnackbar()

    fun isNetworkConnected():Boolean

    fun hideKeyboard()

}