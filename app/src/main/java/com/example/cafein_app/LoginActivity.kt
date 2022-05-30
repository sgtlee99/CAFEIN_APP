package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        var loginbutton = findViewById<Button>(R.id.loginpage_loginbutton)
        loginbutton.setOnClickListener {
            var intent = Intent(this,ViewPager2::class.java)
            startActivity(intent)
        }
    }
}