package com.example.study.model.remote.service.study

import com.example.study.model.data.study.StudyData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface StudyService {

    @GET("/study")
    suspend fun getStudy(): Response<List<StudyData>>

    @POST("/post/study")
    suspend fun saveStudy(@Body data: String): Response<StudyData>

    @PUT("/put/study")
    suspend fun updateStudy(@Body studyData: StudyData):Response<StudyData>

    @DELETE("/delete/study")
    suspend fun deleteStudy(@Query("data") data: String):Response<String>
}