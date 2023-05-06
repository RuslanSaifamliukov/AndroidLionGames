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

class SignIn : AppCompatActivity() {

    var pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val pattern2 = ("[a-z0-9A-Z]{4,34}")

    lateinit var mail: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mail = findViewById(R.id.textName)
        pass = findViewById(R.id.textName2)
    }

    fun emailVaild(text: String): Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun passVaild(text: String): Boolean
    {
        return Pattern.compile(pattern2).matcher(text).matches()
    }

    fun next(view: View)
    {
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            if (emailVaild(mail.text.toString()))
            {
                if (passVaild(pass.text.toString()))
                {
                    val intent = Intent(this@SignIn, Patch::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
            {
                Toast.makeText(this, "Минимальная длина пароля 4 символа!", Toast.LENGTH_SHORT).show()
            }
            }
            else
            {
                Toast.makeText(this, "E-mail введён не корректно!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Введите данные для входа!", Toast.LENGTH_SHORT).show()
        }
    }

    fun recovery(view: View) {
        val intent = Intent(this@SignIn, Recovery::class.java)
        startActivity(intent)
        finish()}
}