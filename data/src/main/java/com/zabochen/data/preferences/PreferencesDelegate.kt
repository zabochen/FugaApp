package com.zabochen.data.preferences

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PreferencesDelegate<T>(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val value: T
) : ReadWriteProperty<Any?, T?> {

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        with(sharedPreferences.edit()) {
            when (value) {
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is String -> putString(key, value)
                else -> throw NotFoundRealizationException(value)
            }
            apply()
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        with(sharedPreferences) {
            return when (value) {
                is Boolean -> (getBoolean(key, value) as T) ?: value
                is Int -> (getInt(key, value) as T) ?: value
                is Long -> (getLong(key, value) as T) ?: value
                is Float -> (getFloat(key, value) as T) ?: value
                is String -> (getString(key, value) as T) ?: value
                else -> throw NotFoundRealizationException(value)
            }
        }
    }
}

class NotFoundRealizationException(private val defaultValue: Any?) : Exception() {

    override val message: String?
        get() = "Not found realization for $defaultValue"
}