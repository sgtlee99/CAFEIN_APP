package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity)

        var completebutton = findViewById<Button>(R.id.surveypage_completebutton)

        completebutton.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java) // 설문조사 화면 -> 홈화면
            startActivity(intent)
        }
    }
}