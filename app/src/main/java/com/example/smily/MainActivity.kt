package com.example.smily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        val smile = Smile(this,)
        smile.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(smile)

    }
}