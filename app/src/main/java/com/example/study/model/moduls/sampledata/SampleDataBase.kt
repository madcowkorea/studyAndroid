package com.example.study.model.moduls.sampledata

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.study.model.data.sampledata.SampleData
import com.example.study.model.remote.service.sampledata.SampleDao

@Database(entities = [SampleData::class], version = 1)
abstract class SampleDataBase :RoomDatabase(){
    abstract fun sampleDao(): SampleDao
}