package com.example.cafein_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OriginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.origin_activity)

        var loginbutton = findViewById<Button>(R.id.originpage_loginbutton)
        var signupbutton = findViewById<Button>(R.id.originpage_siginupbutton)
        //로그인 버튼 이벤트
        loginbutton.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java) // 오리진화면 -> 로그인
            startActivity(intent)
        }
        //회원가입 버튼 이벤트
        signupbutton.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java) // 오리진 화면 -> 회원가입
            startActivity(intent)
        }
    }
}