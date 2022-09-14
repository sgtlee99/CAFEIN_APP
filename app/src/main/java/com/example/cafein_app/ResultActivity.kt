package com.example.cafein_app

import DB_Dao_Helper.Login_User
import DB_Dao_Helper.Register_User
import DB_Dao_Helper.RetrofitBuilder
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Index
import kotlinx.android.synthetic.main.result_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultActivity : AppCompatActivity() {
    var group: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        // 설문조사 데이터 받아와 담기
        intent.hasExtra("msg")
        tv_7_1.text = intent.getStringExtra("msg")
        intent.hasExtra("msg1")
        tv_7_2.text = intent.getStringExtra("msg1")
        intent.hasExtra("msg2")
        tv_7_3.text = intent.getStringExtra("msg2")
        intent.hasExtra("msg3")
        tv_7_4.text = intent.getStringExtra("msg3")
        intent.hasExtra("msg4")
        tv_7_5.text = intent.getStringExtra("msg4")
        intent.hasExtra("msg5")
        tv_7_6.text = intent.getStringExtra("msg5")

        //회원가입 데이터 받아오기


        // 조건 검사
        if (tv_7_1.text == "커피" && tv_7_2.text == "데이트" && tv_7_3.text == "아메리카노"
            && tv_7_4.text == "마카롱" && tv_7_5.text == "인스타" && tv_7_6.text == "감성카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_cat) //노
            group = 2
        } else if (tv_7_1.text == "디저트" && tv_7_2.text == "스터디" && tv_7_3.text == "라떼"
            && tv_7_4.text == "케이크" && tv_7_5.text == "블로그" && tv_7_6.text == "동네카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_bear) //파
            group = 3
        } else if (tv_7_1.text == "커피" && tv_7_2.text == "스터디" && tv_7_3.text == "아메리카노"
            && tv_7_4.text == "케이크" && tv_7_5.text == "인스타" && tv_7_6.text == "동네카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_fox) //빨
            group = 1
        } else if (tv_7_1.text == "디저트" && tv_7_2.text == "데이트" && tv_7_3.text == "라떼"
            && tv_7_4.text == "마카롱" && tv_7_5.text == "블로그" && tv_7_6.text == "감성카페"
        ) {
            re_img.setImageResource(R.drawable.originpage_dog) //초
            group = 4
        }

        var next = findViewById<Button>(R.id.next_btn)
        //회원가입 데이터 받기
        var id: String? = intent.getStringExtra("signup_id")
        var pw: String? = intent.getStringExtra("signup_pw")
        var nick: String? = intent.getStringExtra("signup_nick")
        var email: String? = intent.getStringExtra("signup_email")
        var com: String? = intent.getStringExtra("signup_owner")
        var sex: String? = intent.getStringExtra("signup_sex")
        var age: Int? = intent.getIntExtra("signup_age", 20)

        //회원가입 완료
        next.setOnClickListener {

            val re_user = Register_User()
            //아이디, 비번, 닉네임, owner, 이메일, 그룹, 성별, 나이
            re_user.id = id
            re_user.pw = pw
            re_user.nick = nick
            re_user.com = com
            re_user.email = email
            re_user.groups = group.toString()
            re_user.sex = sex
            re_user.age= age
            //            Log.d("BUTTON CLICKED", "$id : $pw : $nick : $email : $com : $sex : $age : $group")
//            Log.d("BUTTON CLICKED", "id : ${user.id}, pw : ${user.password}, nickname : ${}")
            SignUP(re_user)
            Log.d("SHOW_TEST_RESULT", "$id : $pw : $nick : $email : $com : $sex : $age : $group")

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun SignUP(re_user: Register_User) {
        val call = RetrofitBuilder.register_api.getRegisterResponse(re_user)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    Log.d("SHOW_RESPONSE : ", response.body().toString())
                    Toast.makeText(this@ResultActivity, "[회원가입성공]", Toast.LENGTH_SHORT).show()
                    toLoginPage()
                } else {
                    Log.d("SHOW_RESPONSE : ", "FAILURE")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("SHOW_CONNECTION FAILURE : ", "서버 연결 실패 ${t.localizedMessage}")
            }
        })
    }

    fun toLoginPage() {
        startActivity(Intent(applicationContext, LoginActivity::class.java))
    }
}