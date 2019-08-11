package com.zabochen.fugaapp.ui.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zabochen.doman.common.ResultWrapper
import com.zabochen.doman.common.ResultWrapper.Error
import com.zabochen.doman.common.ResultWrapper.Success
import com.zabochen.doman.model.Advice
import com.zabochen.doman.usecases.GetRandomAdviceUseCase
import com.zabochen.fugaapp.common.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomAdviceViewModel @Inject constructor(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase
) : ViewModel() {

    init {
        loadData()
    }

    private val _randomAdvice = MutableLiveData<Advice>()
    val randomAdvice: LiveData<Advice> = _randomAdvice

    private val _dataLoading = MutableLiveData<Boolean>().apply { this.postValue(true) }
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _dataLoadingError = MutableLiveData<Event<String>>()
    val dataLoadingError: LiveData<Event<String>> = _dataLoadingError

    private val _dataRefreshLoading by lazy { MutableLiveData<Boolean>() }
    val dataRefreshLoading: LiveData<Boolean> = _dataRefreshLoading

    fun loadData(refreshState: Boolean = false) {
        viewModelScope.launch {
            val result: ResultWrapper<Advice> = withContext(Dispatchers.IO) {
                getRandomAdviceUseCase(params = GetRandomAdviceUseCase.Params())
            }

            when (result) {
                is Success -> {
                    _randomAdvice.postValue(result.data)
                    _dataLoading.postValue(false)
                }
                is Error -> {
                    _dataLoading.postValue(false)
                    _dataLoadingError.value = Event(result.exception.toString())
                }
            }

            if (refreshState) {
                _dataRefreshLoading.postValue(false)
            }
        }
    }
}

