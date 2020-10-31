package com.tarek.nynew.core.builder;

import com.tarek.nynew.main.presentation.ui.fragment.NyPopularNewsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    NyPopularNewsListFragment getNyPopularNewsListFragment();
}
