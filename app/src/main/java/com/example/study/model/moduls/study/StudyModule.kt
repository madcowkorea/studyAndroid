package com.example.study.model.moduls.study

import com.example.study.common.HostUrl.STUDY_HOST_URL
import com.example.study.model.remote.repository.study.StudyRepository
import com.example.study.model.remote.service.study.StudyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StudyModule{

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(STUDY_HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideStudyService(retrofit: Retrofit):StudyService{
        return retrofit.create(StudyService::class.java)
    }

    @Provides
    @Singleton
    fun provideStudyRepository(studyService: StudyService):StudyRepository{
        return StudyRepository(studyService)
    }
}