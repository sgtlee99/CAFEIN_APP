package com.example.cafein_app

import Adapters.SearchAdapter
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.CardView_Info
import java.util.Locale.filter
import android.widget.Filter.FilterResults
import androidx.recyclerview.widget.LinearLayoutManager


class SearchActivity : AppCompatActivity() {
    val TAG = "SearchActivity"
    lateinit var search_rv : RecyclerView
    lateinit var search_connect : SearchAdapter
    lateinit var searchList : ArrayList<CardView_Info>
    lateinit var search_view_phone_book : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Appbar_Setting()    //앱바 타이틀 수정 (기능 추가 가능)

//        search_rv = findViewById(R.id.searchpage_recyclerview)
//        search_view_phone_book = findViewById(R.id.search_view_phone_book)
//
//        search_view_phone_book.setOnQueryTextListener(searchViewTextListener)
//
//        searchList = tempSearchList()
//        setAdapter()

    }
//    fun tempSearchList(): ArrayList<CardView_Info> {
//        var temp_searchlists = ArrayList<CardView_Info>()
//        temp_searchlists.add(CardView_Info("영진카페", "#복현동 #아메리카노", R.drawable.cafe_front, 3, 2, 5, 4))
//        temp_searchlists.add(CardView_Info("로켓", "#태그1 #태그2", R.drawable.nasa1, 44, 0, 8, 6))
//        temp_searchlists.add(CardView_Info("자동차", "#무슨사진 #이더라", R.drawable.beatle1, 50, 5, 5, 12))
//        temp_searchlists.add(CardView_Info("카페테스트2", "#tag1 #tag2", R.drawable.cafe_front3, 78, 9, 5, 99))
//        return temp_searchlists
//    }
//    //SearchView 텍스트 입력시 이벤트
//    var searchViewTextListener: SearchView.OnQueryTextListener =
//        object : SearchView.OnQueryTextListener {
//            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
//            override fun onQueryTextSubmit(s: String): Boolean {
//                return false
//            }
//
//            //텍스트 입력/수정시에 호출
//            override fun onQueryTextChange(s: String): Boolean {
////                SearchAdapter.filter.filter(s)
//                search_connect.filter.filter(s)
//                Log.d(TAG, "SearchVies Text is changed : $s")
//                return false
//            }
//        }
//    fun setAdapter(){
//        //리사이클러뷰에 리사이클러뷰 어댑터 부착
//        search_rv.layoutManager = LinearLayoutManager(this)
//        search_connect = SearchAdapter(searchList)
//            search_rv.adapter = search_connect
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_appbar2,menu)
        return true
    }


    private fun Appbar_Setting() {
        var search_actionbar : ActionBar = supportActionBar!!
        search_actionbar.setTitle("검색")
    }



}