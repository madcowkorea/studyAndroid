package com.example.study.viewmodel.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study.model.data.sampledata.SampleData
import com.example.study.model.data.study.StudyData
import com.example.study.model.remote.repository.sampledata.SampleRepository
import com.example.study.model.remote.repository.study.StudyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StudyViewModel @Inject constructor(
    private val studyRepository: StudyRepository
):ViewModel(){

    fun getStudy(): Flow<List<StudyData>> = studyRepository.getStudy()

    suspend fun saveStudy(studyData: StudyData){
        studyRepository.saveStudy(studyData)
    }

    suspend fun updateStudy(studyData: StudyData){
        studyRepository.updateStudy(studyData)
    }

    suspend fun deleteStudy(studyData: StudyData){
        studyRepository.deleteStudy(studyData.data)
    }

}