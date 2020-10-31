package com.tarek.nynew.main.data.repository

import androidx.lifecycle.LiveData
import com.tarek.nynew.core.Result
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse

interface NyRepository {
    suspend fun getPopularNews(): LiveData<Result<NyPopularNewsResponse>>
}