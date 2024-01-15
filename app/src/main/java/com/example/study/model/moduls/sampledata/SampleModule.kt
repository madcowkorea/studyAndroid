package com.example.study.model.moduls.sampledata

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.study.model.remote.service.sampledata.SampleDao
import com.example.study.model.remote.repository.sampledata.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SampleModule {

    @Provides
    fun provideDatabase(@ApplicationContext context:Context): SampleDataBase {
        return Room.databaseBuilder(
            context,
            SampleDataBase::class.java,
            "SampleDataBase"
        ).build()
    }

    @Provides
    fun provideSampleDao(database: SampleDataBase): SampleDao {
        return database.sampleDao()
    }

    @Provides
    fun provideSampleRepository(sampleDao: SampleDao): SampleRepository {
        return SampleRepository(sampleDao)
    }
}