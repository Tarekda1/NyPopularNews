package com.tarek.nynew.main.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.tarek.nynew.core.Result
import com.tarek.nynew.core.Status
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse
import com.tarek.nynew.main.data.repository.NyRepository
import javax.inject.Inject

class NyNewsUseCaseImpl @Inject constructor(private val repository: NyRepository) : NyNewsUseCase {
    override suspend fun getPopularNews(): LiveData<Result<NyPopularNewsResponse>> {
        return Transformations.map(repository.getPopularNews()) {
            when (it.status) {
                Status.SUCCESS -> Result.success(it.data)
                Status.LOADING -> Result.loading()
                Status.ERROR -> Result.error(it.exception?.message.toString())
            }
        }
    }

}