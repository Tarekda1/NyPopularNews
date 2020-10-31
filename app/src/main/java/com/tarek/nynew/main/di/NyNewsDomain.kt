package com.tarek.nynew.main.di

import com.tarek.nynew.main.data.repository.NyRepository
import com.tarek.nynew.main.data.repository.NyRepositoryImpl
import com.tarek.nynew.main.domain.NyNewsUseCase
import com.tarek.nynew.main.domain.NyNewsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NyNewsDomain {

    @Binds
    abstract fun bindNyNewsUseCase(
        useCaseImpl: NyNewsUseCaseImpl
    ): NyNewsUseCase

    @Binds
    abstract fun bindRepo(
        repoImpl: NyRepositoryImpl
    ): NyRepository
}