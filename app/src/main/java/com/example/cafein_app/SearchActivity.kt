package com.example.cafein_app

import Adapters.SearchAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.CardView_Info
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_search_include.*


class SearchActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val TAG = "SearchActivity"
    lateinit var searchpage_recyclerview: RecyclerView
    lateinit var searchpage_searchview: SearchView

    lateinit var searchAdapter: SearchAdapter
    lateinit var itemList: ArrayList<CardView_Info>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_search)
        setContentView(R.layout.activity_search_include)

        Appbar_Setting()    //앱바 타이틀 수정 (기능 추가 가능)

        //함수 처리 필요 네비게이션 드로워 확인버튼 액션
        filter_set_button.setOnClickListener {
            Toast.makeText(this, "필터 확인", Toast.LENGTH_SHORT).show()
            main_drawer_layout.closeDrawers()
        }

//        var main_navigationView = findViewById<NavigationView>(R.id.main_navigationView)
        main_navigationView.setNavigationItemSelectedListener(this)

        searchpage_recyclerview = findViewById(R.id.searchpage_recyclerview)
        searchpage_searchview = findViewById(R.id.searchpage_searchview)
//        searchpage_searchview = findViewById(R.id.searchview_toolbtn)

        searchpage_searchview.setOnQueryTextListener(searchViewTextListener)

        itemList = tempCards()
        setAdapter()


    }

    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            //텍스트 입력/수정시에 호출
            override fun onQueryTextChange(s: String): Boolean {
//                phoneBookListAdapter.filter.filter(s)
//                CardViewAdapter.filter.filter(s)
                searchAdapter.filter.filter(s)

                Log.d(TAG, "SearchView's Text is changed : $s")
                return false
            }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_appbar2, menu)
        return true
    }


    private fun Appbar_Setting() {
        var search_actionbar: ActionBar = supportActionBar!!
        search_actionbar.setTitle("검색")
    }

    fun setAdapter() {
        searchpage_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        searchAdapter = SearchAdapter(itemList, this)
        searchpage_recyclerview.adapter = searchAdapter
    }

    fun tempCards(): ArrayList<CardView_Info> {
        var tempCards = ArrayList<CardView_Info>()
        tempCards.add(CardView_Info("영진카페", "#복현동 #아메리카노", R.drawable.friend, 3, 2, 5, 4))
        tempCards.add(CardView_Info("로켓", "#태그1 #태그2", R.drawable.cafe_front, 44, 0, 8, 6))
        tempCards.add(CardView_Info("자동차", "#무슨사진 #이더라", R.drawable.beatle1, 50, 5, 5, 12))
        tempCards.add(CardView_Info("카페테스트2", "#tag1 #tag2", R.drawable.nasa1, 78, 9, 5, 99))
        return tempCards
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.account -> Toast.makeText(this, "account clicked", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchview_filter -> {
                main_drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
//    override fun onBackPressed() { //뒤로가기 처리
//        if(main_drawer_layout.isDrawerOpen(GravityCompat.START)){
//            main_drawer_layout.closeDrawers()
//            // 테스트를 위해 뒤로가기 버튼시 Toast 메시지
//            Toast.makeText(this,"back btn clicked",Toast.LENGTH_SHORT).show()
//        } else{
//            super.onBackPressed()
//        }
//    }

}