package com.example.cafein_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Index
import kotlinx.android.synthetic.main.result_activity.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

//        var sns1 = findViewById<RadioButton>(R.id.sns_but1)
//        var sns2 = findViewById<RadioButton>(R.id.sns_but2)
//
//        if (sns1.isChecked) {
//            re_img.setImageResource(R.drawable.originpage_cat)
//        } else if (sns2.isChecked) {
//            re_img.setImageResource(R.drawable.originpage_bear)
//        }


        if (intent.hasExtra("msg")) {
            tv_7.text = intent.getStringExtra("msg")
            if (tv_7.text == "감성카페") {
                re_img.setImageResource(R.drawable.originpage_cat)
            } else if (tv_7.text == "동네카페") {
                re_img.setImageResource(R.drawable.originpage_bear)
            }
        }




        var next = findViewById<Button>(R.id.next_btn)

        next.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}