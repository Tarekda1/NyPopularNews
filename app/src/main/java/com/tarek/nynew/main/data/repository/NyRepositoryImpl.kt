package com.tarek.nynew.main.data.repository

import com.tarek.nynew.core.Result
import androidx.lifecycle.liveData
import com.tarek.nynew.main.data.remote.source.NyRemoteDataSource
import javax.inject.Inject

class NyRepositoryImpl @Inject constructor(
    private val remoteDataSource: NyRemoteDataSource) : NyRepository{

    override suspend fun getPopularNews()= liveData {
        emit(Result.loading())
        try {
            System.out.println("calling remoteDataSource")
            val popularNews = remoteDataSource.getPopularNews()
            emit(Result.success(popularNews))
        } catch (exception: Exception) {
            emit(Result.error(exception?.message.toString()))
        }
    }
}