package com.example.cafein_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class ViewPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager2)

//        val spring: SpringDotsIndicator = findViewById(R.id.spring)

        val vp: ViewPager2 = findViewById(R.id.vp)

        val viewpagerFragmentAdapter = ViewPagerAdapter(this)

        vp.adapter = viewpagerFragmentAdapter
//        spring.setViewPager2(vp)

    }
}