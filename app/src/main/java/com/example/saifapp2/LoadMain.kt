package com.example.saifapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LoadMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_main)
        val timer = object : CountDownTimer(2000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@LoadMain, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}