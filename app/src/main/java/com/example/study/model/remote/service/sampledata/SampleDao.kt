package com.example.study.model.remote.service.sampledata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.study.model.data.sampledata.SampleData
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {
    @Insert
    suspend fun sampleInsert(sampleData: SampleData)

    @Query("SELECT * FROM Sample_TB ORDER BY id DESC")
    fun getSampleData(): Flow<SampleData>

    @Query("UPDATE Sample_TB SET data = :data WHERE id = :id")
    suspend fun sampleDataUpdate(id:Int ,data:String)

    @Delete
    suspend fun sampleDataDelete(sampleData: SampleData)
}