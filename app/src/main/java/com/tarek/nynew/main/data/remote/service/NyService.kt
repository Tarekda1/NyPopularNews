package com.tarek.nynew.main.data.remote.service

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.tarek.nynew.BuildConfig.nyapiUrl
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse

interface NyService {
    @GET("${nyapiUrl}")
    @Headers("Cache-control: no-cache")
    fun getPopularNews(): Deferred<Response<NyPopularNewsResponse>>
}