package com.example.study.model.data.sampledata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sample_TB")
data class SampleData(
    @PrimaryKey(autoGenerate = true)val id:Int,
    @ColumnInfo val data:String
)
