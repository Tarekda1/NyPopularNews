package com.tarek.nynew.main.data.remote.source

import com.google.gson.reflect.TypeToken
import com.ouday.core.di.qualifier.CoroutinesIO
import kotlinx.coroutines.withContext
import com.tarek.nynew.main.data.remote.service.NyService
import javax.inject.Inject
import com.tarek.nynew.core.cache.Cache
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse
import retrofit2.Response
import kotlin.coroutines.CoroutineContext



class NyRemoteDataSourceImpl @Inject constructor(
    private val nyService: NyService,
    @CoroutinesIO private val context: CoroutineContext,
    private val cache: Cache
) : NyRemoteDataSource {
    override suspend fun getPopularNews() =withContext(context) {
        val type = object : TypeToken<Response<NyPopularNewsResponse>>() {}.rawType
        val local = cache.find(type as Class<Response<NyPopularNewsResponse>>)
        System.out.println("local:"+local)
        if (local!=null) local.body()
        val response = nyService.getPopularNews().await()
        if (response.isSuccessful) {
            response.body() ?: throw Exception("no Response")
        } else {
            throw Exception("invalid request with code ${response.code()}")
        }
    }


}