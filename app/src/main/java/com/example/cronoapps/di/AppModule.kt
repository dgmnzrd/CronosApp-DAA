package com.example.cronoapps.di

import android.content.Context
import androidx.room.Room
import com.example.cronoapps.room.CronosDatabase
import com.example.cronoapps.room.CronosDatabaseDao
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideCronosDao(cronosDatabase: CronosDatabase): CronosDatabaseDao {
        return cronosDatabase.cronosDao()
    }

    @Singleton
    @Provides
    fun provideCronosDatabase(@ApplicationContext context: Context): CronosDatabase {
        return Room.databaseBuilder(
            context,
            CronosDatabase::class.java,
            "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}