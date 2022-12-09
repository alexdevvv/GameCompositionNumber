package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamecompositionnumber.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.general_fragment_container, WelcomeFragment()).commit()
    }
}