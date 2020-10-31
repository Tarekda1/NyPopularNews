package com.tarek.nynew.main.domain

import androidx.lifecycle.LiveData
import com.tarek.nynew.core.Result
import com.tarek.nynew.main.data.model.NewsResponseModel
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse

interface NyNewsUseCase {
    suspend fun getPopularNews(): LiveData<Result<NyPopularNewsResponse>>
}