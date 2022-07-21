package com.example.cafein_app

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

        infochage_btnGallery.setOnClickListener {
            openGallery()
        }

        ok_button.setOnClickListener {

            var chg_pw = infochange_pw.text.toString()
            var chg_nick = infochange_nick.text.toString()
            var chg_email = infochange_email.text.toString()
//            var chg_profile =
            var chg_age = infochange_age.text.toString()

            infochange_gender.setOnCheckedChangeListener { radioGroup2, i ->
                when (i) {
                    R.id.infochange_gender_male -> chg_gender = "MALE"
                    R.id.infochange_gender_female -> chg_gender = "FEMALE"
                }
            }

            Log.d("SHOW_TEST_DATA", "$chg_pw $chg_nick $chg_email $chg_age $chg_gender")

            toHomeActivity()
        }

//        sur_button.setOnClickListener {
//            var intent = Intent(this, signuppack.SurveryActivity::class.java)
//            startActivity(intent)
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)


        if (requestCode == 102 && resultCode == Activity.RESULT_OK){
            currentImageURL = intent?.data
            // Base64 인코딩부분
            val ins: InputStream? = currentImageURL?.let {
                applicationContext.contentResolver.openInputStream(it)
            }
            val img: Bitmap = BitmapFactory.decodeStream(ins)
            ins?.close()
            val resized = Bitmap.createScaledBitmap(img, 256, 256, true)
            val byteArrayOutputStream = ByteArrayOutputStream()
            resized.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream)
            val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
            val outStream = ByteArrayOutputStream()
            val res: Resources = resources
            profileImageBase64 = Base64.encodeToString(byteArray, NO_WRAP)
            // 여기까지 인코딩 끝

            // 이미지 뷰에 선택한 이미지 출력
//            val imageview: CircleImageView = findViewById(id.infochange_profile)
//            imageview.setImageURI(currentImageURL)
            infochange_profile.setImageURI(currentImageURL)
            try {
                //이미지 선택 후 처리
            } catch (e: Exception){
                e.printStackTrace()
            }
        } else{
            Log.d("SHOW_TEST_ERROR", "something wrong")
        }
    }


    private fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)

        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.type = "image/*"
        startActivityForResult(intent, 102)
    }

    fun toHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    fun toSurveyActivity() {
        startActivity(Intent(this, signuppack.SurveryActivity::class.java))
    }
}