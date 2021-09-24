package com.iknowmuch.devicemanager.preference

/**
 *@author: Chen
 *@createTime: 2021/9/24 15:36
 *@description:
 **/
class PreferenceManager(
    deviceIDPreference: DeviceIDPreference,
    httpServerPreference: HttpServerPreference,
    mqttServerPreference: MqttServerPreference,
    keepLivePreference: KeepLivePreference,
    autoJumpTimePreference: AutoJumpTimePreference,
    chargingTimePreference: ChargingTimePreference
) {
    var deviceID by deviceIDPreference
    var httpServer by httpServerPreference
    var mqttServer by mqttServerPreference
    var keepLive by keepLivePreference
    var autoJumpTime by autoJumpTimePreference
    var chargingTime by chargingTimePreference
}