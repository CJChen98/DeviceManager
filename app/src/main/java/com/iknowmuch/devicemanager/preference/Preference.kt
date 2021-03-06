package com.iknowmuch.devicemanager.preference

import com.iknowmuch.devicemanager.BuildConfig
import com.iknowmuch.devicemanager.Config
import com.tencent.mmkv.MMKV

/**
 *@author: Chen
 *@createTime: 2021/8/13 17:54
 *@description:
 **/
class DeviceIDPreference(mmkv: MMKV) :
    MMKVPreference<String>(mmkv, "device_id", "")

class DeptIDPreference(mmkv: MMKV) :
    MMKVPreference<String>(mmkv, "dept_id", "")

class HttpServerPreference(mmkv: MMKV) :
    MMKVPreference<String>(mmkv, "http_server", Config.DEFAULT_HTTP_SERVER)

class MqttServerPreference(mmkv: MMKV) :
    MMKVPreference<String>(mmkv, "mqtt_server", Config.DEFAULT_MQTT_SERVER)

class KeepLivePreference(mmkv: MMKV) : MMKVPreference<Boolean>(mmkv, "keep_live", !BuildConfig.DEBUG)

class AutoJumpTimePreference(mmkv: MMKV) :
    MMKVPreference<Int>(mmkv, "auto_jump_time", Config.DEFAULT_AUTO_JUMP_TIME)

class ChargingTimePreference(mmkv: MMKV) :
    MMKVPreference<Float>(mmkv, "charging_time", Config.DEFAULT_CHARGING_TIME)

class LastMessageTimePreference(mmkv: MMKV) :
    MMKVPreference<Long>(mmkv, "last_message_time", System.currentTimeMillis())

class SerialPortPathPreference(mmkv: MMKV) :
    MMKVPreference<String>(mmkv, "serial_port_path", "/dev/ttyS0")

class TokenPreference(mmkv: MMKV) : MMKVPreference<String>(mmkv, "user_token", "")

/*
* 0. createTime
* 1. newVersion
*
* */
class UpdateRecordPreference(mmkv: MMKV):MMKVPreference<Set<String>>(mmkv,"update_record", setOf())