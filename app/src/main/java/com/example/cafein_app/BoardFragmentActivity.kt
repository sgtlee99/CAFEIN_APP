package com.example.cafein_app

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BoardFragmentActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.home_appbar, menu)
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_fragment_activity)

        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.first -> {
                        val boardFragment = BoardFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, boardFragment).commit()
                    }
                    R.id.second -> {
                        val reviewBoardFragment = ReviewBoardFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, reviewBoardFragment).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }
    }
}