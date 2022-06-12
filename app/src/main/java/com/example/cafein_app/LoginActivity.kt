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


        var login_idCheck = input_loginID.text.toString()
        var login_pwCheck = input_loginPW.text.toString()


        var loginbutton = findViewById<Button>(R.id.loginpage_loginbutton)
        loginbutton.setOnClickListener {


//            var intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
            startLogin()





//            if (db.dao().isUerIDExist(login_idCheck) == null) {
//                //사용자 아이디가 없을 때
//                login_error_dialog("no id found")
//            } else if (db.dao().isUerIDExist(login_idCheck) != null){
//                //사용자 아이디가 있을 때 (로그인 수행)
//                if (login_pwCheck.equals(db.dao().pwcorrect(login_idCheck))) {
//                    //로그인 성공 토스트
//                    Toast.makeText(this, "${login_idCheck}님 로그인 성공입니다.", Toast.LENGTH_SHORT).show()
//                    //일치할때 다음 액티비티로 가는 기능 수행
//                    startLogin()
//                }
//
//
//            }
//            else if () {
//                //아이디는 OK 비밀번호가 일치하지 않을때
//                login_error_dialog("pw not correct")
//            }



        }
    }
    private fun startLogin() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }



//    fun login_error_dialog(type : String) {
//        val dialog = AlertDialog.Builder(this)
//
//        if (type.equals("no id found")) {
//            //아이디가 없을 때
//        } else if (type.equals("pw not correct")) {
//            //비밀번호가 맞지 않을때
//        }
//        val lo_e_dialog_listener = object : DialogInterface.OnClickListener {
//            override fun onClick(dialog : DialogInterface?, which : Int) {
//                TODO("Not yet implemented")
//                when (which) {
//                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "로그인다이얼로그")
//                }
//            }
//        }
//        dialog.setPositiveButton("확인", lo_e_dialog_listener)
//        dialog.show()
//    }
}