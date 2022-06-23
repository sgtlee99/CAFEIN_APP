package com.example.cafein_app

import DB_Dao_Helper.LoginDatabase
import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Room
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.review_writing_activity.*
import java.lang.Exception

class ReviewWritingActivity : AppCompatActivity() {

    val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
    val STORAGE_PERMISSION = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)

    val FLAG_PERM_CAMERA = 98
    val FLAG_PERM_STORAGE = 99

    val FLAG_REQ_CAMERA = 101
    val FLAG_REA_STORAGE = 102

    private val OPEN_GALLERY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_writing_activity)

        if(checkPermission(STORAGE_PERMISSION, FLAG_PERM_STORAGE)) {
            setViews()
        }

        btnGalleryReview.setOnClickListener {
            openGalleryReview()
        }
    }

    private fun setViews() {
        btnCameraReview.setOnClickListener {
            openCameraReview()
        }
    }

    private fun openCameraReview() {
        if(checkPermission(CAMERA_PERMISSION,FLAG_PERM_CAMERA)){
            val intent:Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,FLAG_REQ_CAMERA)
        }
    }

    fun checkPermission(permissions:Array<out String>,flag:Int):Boolean{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for(permission in permissions){
                if(ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,permissions,flag)
                    return false
                }
            }
        }
        return true
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            FLAG_PERM_STORAGE ->{
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(this,"저장소권한 승인필요",Toast.LENGTH_SHORT).show()
                        finish()
                        return
                    }
                }

                setViews()
            }
            FLAG_PERM_CAMERA ->{
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"카메라권한 승인필요",Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                openCameraReview()
            }
        }
    }


    private fun openGalleryReview() {

        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                FLAG_REQ_CAMERA ->{
                    if(data?.extras?.get("data") != null){

                        val bitmap = data?.extras?.get("data") as Bitmap
                        showReviewImage_ImageView.setImageBitmap(bitmap)
                    }
                }
            }
        }

        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == OPEN_GALLERY) {

                var currentImageUri : Uri? = data?.data

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, currentImageUri)
                    showReviewImage_ImageView.setImageBitmap(bitmap)
                } catch(e:Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            Log.d("ActivityResult", "something wrong")
        }
    }
}
