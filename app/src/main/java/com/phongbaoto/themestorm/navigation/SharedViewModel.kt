package com.phongbaoto.themestorm.navigation

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import javax.inject.Inject
@OptIn(InternalSerializationApi::class)
@HiltViewModel
class SharedViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {
    companion object {
        internal lateinit var instance: SharedViewModel
            private set

        fun setInstance(viewModel: SharedViewModel) {
            instance = viewModel
        }

        fun clear(context: Context) {
            context.getSharedPreferences("navigation_prefs", Context.MODE_PRIVATE)
                .edit(commit = true) { clear() }
        }
    }

    private val savedState = hashMapOf<String, Any>()
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "navigation_prefs",
        Context.MODE_PRIVATE
    )

    @OptIn(InternalSerializationApi::class)
    fun <T: Any> put(key: String, value: T?, type: Class<T>){
        if(value == null){
            remove(key)
        }else{
            sharedPreferences.edit(commit = true){
                when(value){
                    is Int -> putInt(key, value)
                    is Long -> putLong(key, value)
                    is Boolean -> putBoolean(key, value)
                    is Float -> putFloat(key, value)
                    is String -> putString(key, value)
                    else -> {
                        putString(key, Json.encodeToString(type.kotlin.serializer(), value = value))
                    }
                }
            }
            savedState[key] = value as Any
        }
    }

    fun <T: Any> put(key: String, value: T?, serializer: KSerializer<T>){
        if (value == null) {
            remove(key)
        } else {
            sharedPreferences.edit(commit = true) {
                when (value) {
                    is Int -> putInt(key, value)
                    is Long -> putLong(key, value)
                    is Boolean -> putBoolean(key, value)
                    is Float -> putFloat(key, value)
                    is String -> putString(key, value)
                    else -> {
                        putString(key, Json.encodeToString(serializer, value = value))
                    }
                }
            }
            savedState[key] = value as Any
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: Any> get(key: String, type: Class<T>, serializer: KSerializer<T>? = null): T?{
        return try {
            var value = savedState[key] as? T
            if (value == null && sharedPreferences.contains(key)) {
                value = when (type) {
                    Int::class.java -> sharedPreferences.getInt(key, -2004) as? T
                    Long::class.java -> sharedPreferences.getLong(key, -2004) as? T
                    Boolean::class.java -> sharedPreferences.getBoolean(key, false) as? T
                    Float::class.java -> sharedPreferences.getFloat(key, -2004f) as? T
                    String::class.java -> sharedPreferences.getString(key, null) as? T
                    else -> {
                        sharedPreferences.getString(key, null)?.let {
                            Json.decodeFromString(serializer ?: type.kotlin.serializer(), it)
                        }
                    }
                }
            }
            value
        } catch (e: Exception) {
            Log.d("simple_navigation", e.stackTraceToString())
            remove(key)
            null
        }
    }
    fun remove(key: String) {
        savedState.remove(key)
        sharedPreferences.edit(commit = true) { remove(key) }
    }
}