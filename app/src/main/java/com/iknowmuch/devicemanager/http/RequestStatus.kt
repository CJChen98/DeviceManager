package com.iknowmuch.devicemanager.http

import com.squareup.moshi.JsonClass

/**
 *@author: Chen
 *@createTime: 2021/8/31 13:45
 *@description:
 **/
@JsonClass(generateAdapter = true)
class RequestStatus<T>(
    var code: Int = 0,
    var error: Throwable? = null,
    var msg: String? = null,
    var status: State = State.STATE_CREATE,
    var json: T? = null,
) {

    fun <T> copy(
        code: Int = 0,
        error: Throwable? = null,
        msg: String? = null,
        status: State = State.STATE_CREATE,
        _data: T? = null,
    ) = RequestStatus(code, error, msg, status, _data)

    enum class State {
        STATE_CREATE,//创建
        STATE_LOADING,//加载中
        STATE_SUCCESS,//成功
        STATE_EMPTY,//数据为null
        STATE_FAILED,//接口请求成功但是服务器返回error
        STATE_ERROR,//请求失败
        STATE_UNKNOWN//未知
    }
}