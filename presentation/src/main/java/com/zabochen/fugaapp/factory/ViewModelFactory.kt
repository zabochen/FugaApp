package com.zabochen.fugaapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory<T : ViewModel> @Inject constructor(private val provider: Provider<T>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return try {
            provider.get() as T
        } catch (e: Exception) {
            throw IllegalArgumentException("Can't find provider for ViewModel class.")
        }
    }
}