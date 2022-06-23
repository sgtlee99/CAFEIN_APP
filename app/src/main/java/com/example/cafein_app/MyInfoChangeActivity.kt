package com.example.cafein_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import signuppack.SurveyFragment1

class MyInfoChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_info_change_activity)

        var ok_button = findViewById<Button>(R.id.infochange_OkButton)
        var sur_button = findViewById<Button>(R.id.infochange_SurveyButton)

        ok_button.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        sur_button.setOnClickListener {
            var intent = Intent(this, signuppack.ViewPager2::class.java)
            startActivity(intent)
        }
    }
}