package com.minha.baseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minha.baseapp.R // Força o import do R da sua baseapp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}