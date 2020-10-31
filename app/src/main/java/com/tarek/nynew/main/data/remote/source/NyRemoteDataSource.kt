package com.tarek.nynew.main.data.remote.source

import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse

interface NyRemoteDataSource {
    suspend fun getPopularNews(): NyPopularNewsResponse
}