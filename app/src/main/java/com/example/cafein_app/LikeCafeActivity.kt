package com.example.cafein_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafein_app.databinding.LikeCafeActivityBinding
import com.example.myapplication1.CardViewAdapter
import com.example.myapplication1.CardViewAdapter2
import com.example.myapplication1.CardView_Info

class LikeCafeActivity : AppCompatActivity() {

    private lateinit var binding : LikeCafeActivityBinding
    val itemList2 = arrayListOf<CardView_Info>()
    val like_postlist = CardViewAdapter2(itemList2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LikeCafeActivityBinding.inflate(layoutInflater)
//        setContentView(R.layout.like_cafe_activity)
        setContentView(binding.root)

        //레이아웃 매니저와 어댑터 설정
        binding.likeCafeList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.likeCafeList.adapter=like_postlist
        //리스터 이벤트 아직 구현 안함 누르면 에러



        itemList2.add(CardView_Info("영진카페", "#복현동 #아메리카노", R.drawable.cafe_front, 3, 2, 5, 4))
        itemList2.add(CardView_Info("로켓", "#태그1 #태그2", R.drawable.nasa1, 44, 0, 8, 6))
        itemList2.add(CardView_Info("자동차", "#무슨사진 #이더라", R.drawable.beatle1, 50, 5, 5, 12))
        itemList2.add(CardView_Info("카페테스트2", "#tag1 #tag2", R.drawable.cafe_front3, 78, 9, 5, 99))

        like_postlist.notifyDataSetChanged()

        //타이틀 수정
        Appbar_Setting()
    }
    private fun Appbar_Setting() {
        var search_actionbar : ActionBar = supportActionBar!!
        search_actionbar.setTitle("좋아요 한 카페")
    }
}