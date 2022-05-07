package com.example.cafein_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyWrittenBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_written_board_activity)

        var backbutton = findViewById<Button>(R.id.mywrittenboard_BackButton)

        backbutton.setOnClickListener {
            finish()
        }
    }
}