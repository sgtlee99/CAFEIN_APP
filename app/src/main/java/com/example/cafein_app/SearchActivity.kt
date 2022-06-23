package com.example.cafein_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar

class SearchActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_appbar2,menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Appbar_Setting()


    }
    private fun Appbar_Setting() {
        var search_actionbar : ActionBar = supportActionBar!!
        search_actionbar.setTitle("검색")
    }

}