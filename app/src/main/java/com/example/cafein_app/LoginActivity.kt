package com.example.cafein_app

import DB_Dao_Helper.LoginDatabase
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Query
import androidx.room.Room
import kotlinx.android.synthetic.main.login_activity.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // db 연결
        val db = Room.databaseBuilder(
            applicationContext, LoginDatabase::class.java, "database"
        ).allowMainThreadQueries().build()

        // db에 저장된 데이터 불러오기
        db.dao().getAll().observe(this, Observer { todos ->
            dbtest.text = todos.toString()
        })

        db.TagDao().tag_getAll().observe(this, Observer { todos ->
            tagtest.text = todos.toString()
        })

        //로그인 버튼을 눌렀을때
        var loginbutton = findViewById<Button>(R.id.loginpage_loginbutton)
        loginbutton.setOnClickListener {

            startLogin()

//            var login_idCheck = input_loginID.text.toString()
//            var login_pwCheck = input_loginPW.text.toString()
//
//            if (db.dao().isUserIDExist(login_idCheck) != null) {    //아이디가 널이 아닐때 -> 있을때
//                if(db.dao().pwcorrect(login_idCheck).equals(login_pwCheck)) {
//                    // pwcorrect 는 아이디를 넣으면 비밀번호를 반환하는 함수
//                    // pwcorrect에서 반환받은 비밀번호와 사용자가 입력한 비밀번호가 같다면 로그인 성공
//                    Toast.makeText(this, "${db.dao().showNickname(login_idCheck)} 님 안녕하세요!", Toast.LENGTH_SHORT).show()
//                    startLogin()
//                } else {
//                    login_error_dialog("pw not correct")
//                }
//            } else {
//                login_error_dialog("id not found")
//            }

        }
    }
    private fun startLogin() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }

    fun login_error_dialog(type : String) {
        val dialog = AlertDialog.Builder(this)

        if (type.equals("id not found")) {
            //아이디가 없을 때
            dialog.setTitle("로그인 실패!")
            dialog.setMessage("아이디가 없습니다.")
        } else if (type.equals("pw not correct")) {
            //비밀번호가 맞지 않을때
            dialog.setTitle("로그인 실패!")
            dialog.setMessage("비밀번호가 일치하지 않습니다.")
        }

        val lo_e_dialog_listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog : DialogInterface?, which : Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "로그인다이얼로그")
                }
            }
        }
        dialog.setPositiveButton("확인", lo_e_dialog_listener)
        dialog.show()
    }
}