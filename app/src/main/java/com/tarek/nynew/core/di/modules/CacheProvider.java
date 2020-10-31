package com.tarek.nynew.core.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.tarek.nynew.core.cache.Cache;
import com.tarek.nynew.core.cache.CacheImpl;

@Module
public class CacheProvider {

    @Provides
    @Singleton
    public Cache provideCache(Context context) {
        return new CacheImpl(context);
    }


}
