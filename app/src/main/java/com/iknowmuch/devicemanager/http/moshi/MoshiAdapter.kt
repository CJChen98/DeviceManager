package com.iknowmuch.devicemanager.http.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.internal.Util
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

/**
 *@author: Chen
 *@createTime: 2021/8/14 22:27
 *@description:
 **/

val moshi: Moshi by lazy {
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
//        .add(StringAdapter())
//        .add(IntAdapter())
//        .add(FloatAdapter())
//        .add(DoubleAdapter())
//        .add(BooleanAdapter())
//        .add(LongAdapter())
//        .add(AnyAdapter())
        .build()
}


class StringAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""

    }

    @ToJson
    fun toJson(writer: JsonWriter, value: String?) {
        writer.value(value.toString())
    }
}

class FloatAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Float {
        with(reader) {
            return when (peek()) {
                JsonReader.Token.NULL -> {
                    nextNull<Any>()
                    0f
                }
                else -> {
                    nextDouble().toFloat()
                }
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: Float?) {
        writer.value(value.toString())
    }
}

class IntAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Int {
        with(reader) {
            return when (peek()) {
                JsonReader.Token.NULL -> {
                    nextNull<Any>()
                    0
                }
                else -> {
                    nextInt()
                }
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: Int?) {
        writer.value(value.toString())
    }
}

class DoubleAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Double {
        with(reader) {
            return when (peek()) {
                JsonReader.Token.NULL -> {
                    nextNull<Any>()
                    0.toDouble()
                }
                else -> {
                    nextDouble()
                }
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: Double?) {
        writer.value(value.toString())
    }
}

class BooleanAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Boolean {
        with(reader) {
            return when (peek()) {
                JsonReader.Token.NULL -> {
                    nextNull<Any>()
                    false
                }
                else -> {
                    nextBoolean()
                }
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: Boolean?) {
        writer.value(value.toString())
    }
}

class LongAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Long {
        with(reader) {
            return when (peek()) {
                JsonReader.Token.NULL -> {
                    nextNull<Any>()
                    0L
                }
                else -> {
                    nextLong()
                }
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: Long?) {
        writer.value(value.toString())
    }
}

class AnyAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Any {
        return if (reader.peek() != JsonReader.Token.NULL) {
            moshi.adapter(Objects::class.java).fromJson(reader) ?: Any()
        } else {
            Any()
        }
    }
}


internal infix fun Set<Annotation>.containsAssignable(clazz: Class<out Annotation>): Boolean {
    return Util.isAnnotationPresent(this, clazz)
}