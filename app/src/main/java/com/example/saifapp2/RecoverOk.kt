package com.example.saifapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RecoverOk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_ok)
    }

    fun back(view: View) {val intent = Intent(this@RecoverOk, SignIn::class.java)
        startActivity(intent)
        finish()}
}