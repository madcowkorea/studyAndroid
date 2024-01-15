package com.example.study.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.study.R
import com.example.study.databinding.ActivityStudyBinding
import com.example.study.model.data.study.StudyData
import com.example.study.viewmodel.viewmodels.StudyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StudyActivity : AppCompatActivity() {
    private lateinit var studyBinding:ActivityStudyBinding
    private val studyViewModel:StudyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studyBinding = DataBindingUtil.setContentView(this, R.layout.activity_study)
        studyBinding.lifecycleOwner = this
        studyBinding.studyViewModel = studyViewModel

        lifecycleScope.launch {
            studyViewModel.getStudy().collect(){ studyList->
                Log.e("studyList" , studyList.toString())
            }
        }
    }
}