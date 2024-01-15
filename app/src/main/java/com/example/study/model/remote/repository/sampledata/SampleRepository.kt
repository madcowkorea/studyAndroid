package com.example.study.model.remote.repository.sampledata

import com.example.study.model.data.sampledata.SampleData
import com.example.study.model.remote.service.sampledata.SampleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SampleRepository @Inject constructor(
    private val sampleDao: SampleDao
){
    val sampleDataFlow by lazy { sampleDao.getSampleData() }

    suspend fun sampleInsert(sampleData: SampleData){
        sampleDao.sampleInsert(sampleData)
    }

    suspend fun sampleDataUpdate(id:Int , data:String){
        sampleDao.sampleDataUpdate(id , data)
    }

    suspend fun sampleDataDelete(sampleData: SampleData){
        sampleDao.sampleDataDelete(sampleData)
    }

}