package com.tarek.nynew.main.presentation.viewmodel


import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.tarek.nynew.core.Result
import androidx.lifecycle.viewModelScope
import com.tarek.nynew.main.data.model.NewsResponseModel
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse
import com.tarek.nynew.main.domain.NyNewsUseCase
import javax.inject.Inject

class NyNewsViewModel @Inject constructor(
    private val useCase: NyNewsUseCase
) : ViewModel() {
    private val nyNewsLiveData = MediatorLiveData<Result<NyPopularNewsResponse>>()
    fun getAllNyPopularNewsLiveData() = nyNewsLiveData

    fun requestPopularNyNewsList() {
        viewModelScope.launch {
            nyNewsLiveData.addSource(useCase.getPopularNews()) {
                nyNewsLiveData.value = it
            }
        }
    }

}