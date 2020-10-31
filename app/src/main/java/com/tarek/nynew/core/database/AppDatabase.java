package com.tarek.nynew.core.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tarek.nynew.core.cache.CacheRow;
import com.tarek.nynew.core.cache.CacheRowDao;

@Database(entities = {CacheRow.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CacheRowDao cacheRowDao();
}