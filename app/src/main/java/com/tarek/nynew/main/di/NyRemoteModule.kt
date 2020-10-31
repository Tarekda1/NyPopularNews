package com.tarek.nynew.main.di

import com.tarek.nynew.main.data.remote.service.NyService
import com.tarek.nynew.main.data.remote.source.NyRemoteDataSource
import com.tarek.nynew.main.data.remote.source.NyRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NyRemoteModule.Binders::class])
class NyRemoteModule {
    @Module
    interface Binders {
        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: NyRemoteDataSourceImpl
        ): NyRemoteDataSource
    }

    @Provides
    fun providesService(retrofit: Retrofit): NyService =
        retrofit.create(NyService::class.java)
}