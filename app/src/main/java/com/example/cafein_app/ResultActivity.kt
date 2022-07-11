package com.example.cafein_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Index
import kotlinx.android.synthetic.main.result_activity.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        // 설문조사 데이터 받아와 담기
        intent.hasExtra("msg")
        tv_7_1.text = intent.getStringExtra("msg")
        intent.hasExtra("msg1")
        tv_7_2.text = intent.getStringExtra("msg1")
        intent.hasExtra("msg2")
        tv_7_3.text = intent.getStringExtra("msg2")
        intent.hasExtra("msg3")
        tv_7_4.text = intent.getStringExtra("msg3")
        intent.hasExtra("msg4")
        tv_7_5.text = intent.getStringExtra("msg4")
        intent.hasExtra("msg5")
        tv_7_6.text = intent.getStringExtra("msg5")

        //회원가입 데이터 받아오기



        // 조건 검사
        if (tv_7_1.text == "커피" && tv_7_2.text == "데이트" && tv_7_3.text == "아메리카노"
            && tv_7_4.text == "마카롱" && tv_7_5.text == "인스타" && tv_7_6.text == "감성카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_cat)
        } else if (tv_7_1.text == "디저트" && tv_7_2.text == "스터디" && tv_7_3.text == "라떼"
            && tv_7_4.text == "케이크" && tv_7_5.text == "블로그" && tv_7_6.text == "동네카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_bear)
        } else if (tv_7_1.text == "커피" && tv_7_2.text == "스터디" && tv_7_3.text == "아메리카노"
            && tv_7_4.text == "케이크" && tv_7_5.text == "인스타" && tv_7_6.text == "동네카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_fox)
        } else if (tv_7_1.text == "디저트" && tv_7_2.text == "데이트" && tv_7_3.text == "라떼"
            && tv_7_4.text == "마카롱" && tv_7_5.text == "블로그" && tv_7_6.text == "감성카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_dog)
        }

        var next = findViewById<Button>(R.id.next_btn)
        //회원가입 데이터 받기
        var id : String? = intent.getStringExtra("signup_id")
        var pw : String? = intent.getStringExtra("signup_pw")
        var nick : String? = intent.getStringExtra("signup_nick")
        var email : String? = intent.getStringExtra("signup_email")
        var isowner : Boolean? = intent.getBooleanExtra("signup_owner",true)
        var ismale : Boolean? = intent.getBooleanExtra("signup_sex",true)
        var age : Int? = intent.getIntExtra("signup_age",20)

        //회원가입 완료
        next.setOnClickListener {

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}