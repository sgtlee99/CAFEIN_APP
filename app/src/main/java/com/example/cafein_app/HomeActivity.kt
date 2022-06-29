package com.example.cafein_app

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.databinding.HomeActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchview_button -> {
                toSearch()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
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

                        val builder = AlertDialog.Builder(context)
                            .setTitle("Warning")
                            .setMessage("사용자는 점주가 아닙니다")
                            .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, which ->
                                Toast.makeText(context, "확인", Toast.LENGTH_SHORT).show()
                            })

                            .setNegativeButton("취소", DialogInterface.OnClickListener{ dialog, which ->
                                Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
                            })
                        builder.show()

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

