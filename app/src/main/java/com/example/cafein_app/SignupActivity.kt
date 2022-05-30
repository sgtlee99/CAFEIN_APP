package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        var signupnextbutton = findViewById<Button>(R.id.signuppage_NextButton)

        signupnextbutton.setOnClickListener {
            var intent = Intent(this, ViewPager2::class.java)
            startActivity(intent)
        }
    }
}