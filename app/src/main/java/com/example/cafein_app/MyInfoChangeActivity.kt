package com.example.cafein_app

import DB_Dao_Helper.Register_User
import DB_Dao_Helper.RetrofitBuilder
import DB_Dao_Helper.Update_User
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Base64.NO_WRAP
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager2.widget.ViewPager2
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.my_info_change_activity.*
import kotlinx.android.synthetic.main.signup_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.InputStream
import kotlin.math.sign

class MyInfoChangeActivity : AppCompatActivity() {

    var chg_gender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_info_change_activity)

        var ok_button = findViewById<Button>(R.id.infochange_OkButton)
        var sur_button = findViewById<Button>(R.id.infochange_SurveyButton)

        ok_button.setOnClickListener {

            var chg_pw = infochange_pw.text.toString()
            var chg_nick = infochange_nick.text.toString()
            var chg_email = infochange_email.text.toString()
//            var chg_profile =
            var chg_age = infochange_age.text.toString()

            infochange_gender.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    R.id.infochange_gender_male -> chg_gender = "MALE"
                    R.id.infochange_gender_female -> chg_gender = "FEMALE"
                }
            }

            Log.d("SHOW_TEST_DATA", "$chg_pw $chg_nick $chg_email $chg_age $chg_gender")

            //회원정보 수정
            //비밀번호, 닉네임, 이메일, 나이, 성별

            var up_user = Update_User()
            up_user.pw = chg_pw
            up_user.nick = chg_nick
            up_user.email = chg_email
            up_user.age = chg_age.toInt()
            up_user.sex = chg_gender
            Update(up_user)
            Log.d("SHOW_TEST_RESULT", "$chg_pw $chg_nick $chg_email $chg_age $chg_gender")



        }

//        sur_button.setOnClickListener {
//            var intent = Intent(this, signuppack.SurveryActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun Update(up_user: Update_User) {
        val call = RetrofitBuilder.update_api.getUpdateResponse(up_user)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    Log.d("SHOW_RESPONSE : ", response.body().toString())
                    Toast.makeText(this@MyInfoChangeActivity, "[정보 수정 성공]", Toast.LENGTH_SHORT).show()
                    toHomeActivity()
                } else {
                    Log.d("SHOW_RESPONSE : ", "FAILURE")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("SHOW_CONNECTION FAILURE : ", t.localizedMessage)
            }
        })
    }

    fun toHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    fun toSurveyActivity() {
        startActivity(Intent(this, signuppack.SurveryActivity::class.java))
    }
}