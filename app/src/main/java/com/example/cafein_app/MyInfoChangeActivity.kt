package com.example.cafein_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyInfoChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_info_change_activity)

        var backbutton = findViewById<Button>(R.id.infochange_BackButton)
        var okbutton = findViewById<Button>(R.id.infochange_OkButton)

        backbutton.setOnClickListener {
            finish()
        }

        okbutton.setOnClickListener {
            var intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
        }
    }
}