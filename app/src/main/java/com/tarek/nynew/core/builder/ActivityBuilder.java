package com.tarek.nynew.core.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.tarek.nynew.main.presentation.ui.activity.MainActivity;

@Module
public interface ActivityBuilder {

    @ContributesAndroidInjector
    MainActivity getMainActivity();

}
