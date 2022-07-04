package com.example.cafein_app

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.RoundedCorner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.databinding.HomeActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    // 점주가 아닌 사용자가 글작성 프래그먼트로 이동하면 다이얼로그 띄우고 홈 프래그먼트로 이동시킴
    private fun showPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_popup_writingfragment, null)
        val textView: TextView = view.findViewById(R.id.textView3)
        textView.text = "사용자는 점주가 아닙니다"

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Warning")
            .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, which ->
                Toast.makeText(applicationContext, "이전으로", Toast.LENGTH_SHORT).show()

                // 나중에 보완할 코드
                //supportFragmentManager.beginTransaction()
                //    .replace(R.id.second, WritingFragment())
                //    .addToBackStack(null)
                //    .commit()


                // 확인 누를때 홈 프래그먼트로 이동시키는 코드 (주석해제)
                //var intent = Intent(this, HomeActivity::class.java)
                //startActivity(intent)

            })
            .create()

        alertDialog.setView(view)
        alertDialog.show()
    }

    private lateinit var binding: HomeActivityBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.searchview_button -> {
                toSearch()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun toSearch() {
        startActivity(Intent(applicationContext, SearchActivity::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var action_bar: ActionBar = supportActionBar!!

        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView
//d
        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.first -> {
                        // 다른 프래그먼트 화면으로 이동하는 기능
                        val homeFragment = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()
                        action_bar.setTitle("CAFE-IN")

                    }
                    R.id.second -> {
                        val writingFragment = WritingFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, writingFragment).commit()
                        action_bar.setTitle("글쓰기")

                        // 글 작성 프래그먼트 이동시 다이얼로그 띄움 (점주가 접근시 뜨지않게해야함)
                        showPopup()


                        //val builder = AlertDialog.Builder(context)
                        //    .setTitle("Warning")
                        //    .setMessage("사용자는 점주가 아닙니다")
                        //    .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, which ->
                        //        Toast.makeText(context, "확인", Toast.LENGTH_SHORT).show()

                                // 테스트
                                //finish()
                                //onBackPressed()
                                //supportFragmentManager.beginTransaction()
                                //    .replace(R.id.first, HomeFragment())
                                //    .addToBackStack(null)

                            //})

                            //.setNegativeButton("취소", DialogInterface.OnClickListener{ dialog, which ->
                            //    Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
                            //})
                        //builder.show()

                    }
                    R.id.third -> {
                        val settingFragment = SettingFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, settingFragment).commit()
                        action_bar.setTitle("설정")

                    }
                }
                true
            }
            selectedItemId = R.id.first
        }
    }

}

