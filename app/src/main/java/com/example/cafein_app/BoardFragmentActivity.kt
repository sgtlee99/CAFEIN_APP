package com.example.cafein_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BoardFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_fragment_activity)

        var bnv_board = findViewById(R.id.navi_board_main) as BottomNavigationView

        bnv_board.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.board_view -> {
                        // 다른 프래그먼트 화면으로 이동하는 기능
                        val board_view_Fragment = BoardFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.board_container, board_view_Fragment).commit()
                    }
                    R.id.board_review -> {
                        val board_review_Fragment = ReviewBoardFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.board_container, board_review_Fragment).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.board_view
        }

    }
}