package com.example.study.common

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DefaultApplication:Application(){

    override fun onCreate() {
        super.onCreate()
    }
}