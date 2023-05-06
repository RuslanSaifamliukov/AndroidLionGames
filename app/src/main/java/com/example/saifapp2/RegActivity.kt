package com.example.saifapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegActivity : AppCompatActivity()
{
    var pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val pattern2 = ("[a-z0-9A-Z]{4,34}")

    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var repass: EditText
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        mail = findViewById(R.id.EditText)
        pass = findViewById(R.id.EditText2)
        repass = findViewById(R.id.EditText3)
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
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && repass.text.toString().isNotEmpty())
        {
            if (emailVaild(mail.text.toString()))
            {
                if (passVaild(pass.text.toString()))
                {
                    if (pass.text.toString()==repass.text.toString())
                        {
                    val intent = Intent(this@RegActivity, Patch::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Успешно!", Toast.LENGTH_SHORT).show()
                    finish()
                    }
                    else
                    {
                        Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this, "Длина пароля минимум 4 символа!", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "E-mail введён не корректно!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show()
        }
    }
    fun back(view: View) {
        val intent = Intent(this@RegActivity, MainActivity::class.java)
        startActivity(intent)
        finish()}
}