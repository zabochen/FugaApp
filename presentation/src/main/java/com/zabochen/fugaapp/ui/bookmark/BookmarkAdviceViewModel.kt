package com.zabochen.fugaapp.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zabochen.doman.model.Advice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BookmarkAdviceViewModel @Inject constructor() : ViewModel() {

    private val _bookmarkAdviceList by lazy { MutableLiveData<List<Advice>>() }
    val bookmarkAdviceList: LiveData<List<Advice>> = _bookmarkAdviceList

    init {
        loadBookmarkList()
    }

    fun loadBookmarkList() {

        val bookmarkAdviceList = arrayListOf<Advice>()
        for (i in 1..10) {
            bookmarkAdviceList.add(Advice(i, "Advice_$i"))
        }

        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Main) {
                delay(TimeUnit.SECONDS.toMillis(5))
            }
            _bookmarkAdviceList.postValue(bookmarkAdviceList)
        }
    }
}