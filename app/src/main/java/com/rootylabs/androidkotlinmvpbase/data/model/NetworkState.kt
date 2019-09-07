package com.rootylabs.androidkotlinmvpbase.data.model

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

data class NetworkState constructor(
    val status: Status,
    val msg: String? = null) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}