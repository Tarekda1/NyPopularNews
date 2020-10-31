package com.tarek.nynew.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarek.nynew.core.presentation.ViewModelFactory
import com.tarek.nynew.main.presentation.viewmodel.NyNewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import se.appshack.android.refactoring.core.di.modules.ViewModelKey


@Module
abstract  class NyNewsPresentationModule {

    @Binds
    abstract  fun bindsViewModelFactory(factory:ViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NyNewsViewModel::class)
    abstract fun bindsViewModel(viewModel: NyNewsViewModel):ViewModel
}