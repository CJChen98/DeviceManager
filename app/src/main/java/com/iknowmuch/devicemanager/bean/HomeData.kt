package com.iknowmuch.devicemanager.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *@author: Chen
 *@createTime: 2021/10/9 17:00
 *@description:
 **/
@JsonClass(generateAdapter = true)
data class HomeDataJson(
    override val status: Int,
    override val msg: String?,
    val data: HomeData? = null
) : BaseJson()
@JsonClass(generateAdapter = true)
data class HomeData(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "msg")
    val msg: String,
    @Json(name = "status")
    val status: Int
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "CabinetAddress")
        val cabinetAddress: String,
        @Json(name = "cabinetDoorCode")
        val cabinetDoorCode: Int,
        //0启用,1禁用
        @Json(name = "cabinetDoorState")
        val cabinetDoorState: Int,
        //1开,0关
        @Json(name = "closeState")
        val closeState:Int,
        @Json(name = "CabinetName")
        val cabinetName: String,
        @Json(name = "message")
        val message: Message?,
        //0启用，1禁用
        @Json(name = "cabinetEnable")
        val cabinetEnable :String
    ) {
        @JsonClass(generateAdapter = true)
        data class Message(

            @Json(name = "availableTime")
            val availableTime: String?,
            @Json(name = "cabinetDoorNo")
            val cabinetDoorNo: Int,
            @Json(name = "power")
            val power: String?,
            @Json(name = "probeCode")
            val probeCode: String,
            @Json(name = "probeName")
            val probeName: String,
            @Json(name = "probeState")
            val probeState: Int
        )
    }
}