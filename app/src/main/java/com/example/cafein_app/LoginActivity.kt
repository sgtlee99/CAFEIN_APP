package com.example.cafein_app

import DB_Dao_Helper.LoginDatabase
import DB_Dao_Helper.Login_User
import DB_Dao_Helper.RetrofitBuilder
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.cafein_app.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.login_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import signuppack.SignupActivity

class LoginActivity : AppCompatActivity() {
    var id: String = ""
    var pw: String = ""
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

        var userId = findViewById<EditText>(R.id.input_loginID)
        var userPassword = findViewById<EditText>(R.id.input_loginPW)
        //로그인 버튼을 눌렀을때
        var loginbutton = findViewById<Button>(R.id.loginpage_loginbutton)
        loginbutton.setOnClickListener {

//            startLogin()
            id = userId.text.toString()
            pw = userPassword.text.toString()
            val user = Login_User()
            user.id = userId.text.toString()
            user.password = userPassword.text.toString()
            Log.d("BUTTON CLICKED", "id : ${user.id}, pw : ${user.password}")
            Login(user)

        }

    }

    private fun Login(user: Login_User) {
        val call = RetrofitBuilder.api.getLoginResponse(user)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    Log.d("RESPONSE : ", response.body().toString())
                    Toast.makeText(this@LoginActivity,"안녕하세요",Toast.LENGTH_SHORT).show()

                    startLogin()
                } else {
                    Log.d("RESPONSE : ", "FAILURE")
                    login_error_dialog("id not found")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("CONNECTION FAILURE : ", t.localizedMessage)
            }
        })
    }

    private fun startLogin() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }

    fun login_error_dialog(type: String) {
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
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "로그인다이얼로그")
                }
            }
        }
        dialog.setPositiveButton("확인", lo_e_dialog_listener)
        dialog.show()
    }
}