package com.example.study.model.remote.repository.study

import com.example.study.model.data.study.StudyData
import com.example.study.model.remote.service.study.StudyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class StudyRepository @Inject constructor(
    private val studyService: StudyService
){

    fun getStudy(): Flow<List<StudyData>> = flow {
        val response = studyService.getStudy()
        if (response.isSuccessful) {
            response.body()?.let { emit(it) }
        } else {
            throw IllegalArgumentException("getStudy response.isFailed")
        }
    }

    suspend fun saveStudy(studyData: StudyData){
       val response = studyService.saveStudy(studyData.data)
        if(response.isSuccessful){
            getStudy()
        }else{
            throw IllegalArgumentException("saveStudy response.isFailed")
        }
    }

    suspend fun updateStudy(studyData: StudyData){
        val response = studyService.updateStudy(studyData)
        if(response.isSuccessful){

        }else{
            throw IllegalArgumentException("updateStudy response.isFailed")
        }
    }

    suspend fun deleteStudy(data:String){
        val response =  studyService.deleteStudy(data)
        if(response.isSuccessful){

        }else{
            throw IllegalArgumentException("deleteStudy response.isFailed")
        }
    }
}