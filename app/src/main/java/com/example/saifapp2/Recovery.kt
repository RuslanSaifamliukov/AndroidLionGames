package com.example.saifapp2

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class Recovery : AppCompatActivity() {

    var pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    lateinit var mail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        mail = findViewById(R.id.EditText)
    }

    fun emailVaild(text: String): Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun recoveryok(view: View)
    {
        if (mail.text.toString().isNotEmpty())
        {
            if (emailVaild(mail.text.toString()))
            {
                val intent = Intent(this@Recovery, RecoverOk::class.java)
                startActivity(intent)
                Toast.makeText(this, "Успешно!", Toast.LENGTH_SHORT).show()
                finish()
            }
            else
            {
                Toast.makeText(this, "E-mail введён не корректно!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Введите E-mail для восстановления!", Toast.LENGTH_SHORT).show()
        }
    }
    fun back(view: View) {val intent = Intent(this@Recovery, SignIn::class.java)
        startActivity(intent)
        finish()}
}