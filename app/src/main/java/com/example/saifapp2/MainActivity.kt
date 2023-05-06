package com.example.saifapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    fun next(view: View) {
        val intent = Intent(this@MainActivity, SignIn::class.java)
        startActivity(intent)
        finish()}
    fun back(view: View) {
        val intent = Intent(this@MainActivity, RegActivity::class.java)
        startActivity(intent)
        finish()}
}