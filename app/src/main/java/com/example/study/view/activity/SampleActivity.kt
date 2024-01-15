package com.example.study.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.study.R
import com.example.study.databinding.ActivitySampleBinding
import com.example.study.viewmodel.viewmodels.SampleViewModel
import com.example.study.viewmodel.viewmodels.StudyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {
    private lateinit var sampleBinding: ActivitySampleBinding
    private val sampleViewModel:SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sampleBinding = DataBindingUtil.setContentView(this, R.layout.activity_sample)
        sampleBinding.lifecycleOwner = this
        sampleBinding.sampleViewModel = sampleViewModel

        //데이터 내용 호출
        lifecycleScope.launch {
            sampleViewModel.sampleDataFlow.collect(){getSampleData ->
                Log.e("getSampleData" , getSampleData.toString())
            }
        }
    }
}