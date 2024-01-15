package com.example.study.model.data.study

import com.google.gson.annotations.SerializedName

data class StudyData(
    @SerializedName("id")
    val id:Int,
    @SerializedName("data")
    val data:String
)
