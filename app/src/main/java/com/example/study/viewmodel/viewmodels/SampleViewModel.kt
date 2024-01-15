package com.example.study.viewmodel.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study.model.data.sampledata.SampleData
import com.example.study.model.remote.repository.sampledata.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
): ViewModel(){

    //데이터 리스트
    val sampleDataFlow by lazy { sampleRepository.sampleDataFlow }

    //데이터 추가
    fun sampleInsert(sampleData: SampleData){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                sampleRepository.sampleInsert(sampleData) //Insert 가 성공 적으로 실행후 이후 코드 실행
            }
        }
    }

    //데이터 업데이트
    fun sampleDataUpdate(id:Int , data:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                sampleRepository.sampleDataUpdate(id , data)
            }
        }
    }

    //데이터 삭제
    fun sampleDataDelete(sampleData: SampleData){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                sampleRepository.sampleDataDelete(sampleData)
            }
        }
    }
}