package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        var next = findViewById<Button>(R.id.next_btn)

        next.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        var share = getSharedPreferences("sign",0)
        var result_text = findViewById<TextView>(R.id.result_tv)
        result_text.text = share.getString("id","")
//        + share.getString("pw","") + share.getString("nick","")+share.getString("email","")
    }
}