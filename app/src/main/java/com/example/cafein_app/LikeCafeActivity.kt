package com.example.cafein_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LikeCafeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.like_cafe_activity)

        var backbutton = findViewById<Button>(R.id.likecafe_BackButton)

        backbutton.setOnClickListener {
            finish()
        }
    }
}