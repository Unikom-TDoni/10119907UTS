package com.tdoni_10119907.a10119907uts.presentation.activity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tdoni_10119907.a10119907uts.R

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class MainActivity : AppCompatActivity() {

    private var isScreenReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplashScreen()
        startSplashScreenTimer()
        setContentView(R.layout.activity_main)
    }

    private fun startSplashScreenTimer() {
        val timer = object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                isScreenReady = true
            }
        }
        timer.start()
    }

    private fun initSplashScreen() =
        installSplashScreen().apply { setKeepOnScreenCondition { !isScreenReady } }

}