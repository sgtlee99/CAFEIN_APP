package com.example.cafein_app

import DB_Dao_Helper.LoginDatabase
import DB_Dao_Helper.Tag_Info
import android.Manifest
import android.Manifest.permission.CAMERA
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.cafein_app.databinding.FragmentWritingBinding
import kotlinx.android.synthetic.main.fragment_writing.*
import kotlinx.android.synthetic.main.fragment_writing.view.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat

class WritingFragment : Fragment() {

    private val GALLERY = 1

    val REQ_CAMERA = 100
    val REQ_STORAGE = 99

    var realUri: Uri? = null

    private var mBinding: FragmentWritingBinding? = null
    private val binding get() = mBinding!!

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // 허용눌렀을때
                Toast.makeText(context, "Grant", Toast.LENGTH_SHORT).show()
            } else {
                // 거부했을때
                Toast.makeText(context, "Deny", Toast.LENGTH_SHORT).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //프래그먼트에 사용할때는 activity!!. 붙여주기


        var btnOpenGallery = view?.findViewById<Button>(R.id.btnGallery)
        btnOpenGallery?.setOnClickListener {
            openGallery()
            //val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            //intent.setType("image/*")
            //startActivityForResult(intent,GALLERY)
        }


        var btnOpenCamera = view?.findViewById<Button>(R.id.btnCamera)
        btnOpenCamera?.setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            openCamera()
        }
    }

    // var realUri: Uri? = null

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        createImageUri(newFileName(), "image/jpg")?.let {
            realUri = it
            intent.putExtra(MediaStore.EXTRA_OUTPUT,realUri)
            startActivityForResult(intent, REQ_CAMERA)
        }
    }


    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_STORAGE)
    }


    fun createImageUri(filename: String, mimeType: String): Uri? {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME,filename)
        values.put(MediaStore.Images.Media.MIME_TYPE,mimeType)
        return binding.root.context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
    }


    fun newFileName(): String {
        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "$filename.jpg"
    }

    fun loadBitmap(photoUri: Uri):Bitmap ?{
        var image: Bitmap? = null
        try {
            image = if(Build.VERSION.SDK_INT>27) {   // API버전별 이미지 처리
                val source: ImageDecoder.Source=ImageDecoder.createSource(binding.root.context.contentResolver,photoUri)
                ImageDecoder.decodeBitmap(source)
            }else {
                MediaStore.Images.Media.getBitmap(binding.root.context.contentResolver,photoUri)
            }
        }catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }


    // 뷰 바인딩 관련코드는 북마크 블로그 참고
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentWritingBinding.inflate(inflater, container, false)

        val view = inflater.inflate(R.layout.fragment_writing, container, false)

        return binding.root
        // return view

        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_CAMERA -> {
                    realUri?.let {
                        val bitmap = loadBitmap(it)
                        binding.showImageImageView.setImageBitmap(bitmap)
                        realUri = null
                    }
                }
                REQ_STORAGE->{
                    data?.data?.let {
                        binding.showImageImageView.setImageURI(it)
                    }
                }
            }
        }else{
            Log.d("", "onActivityResult false")
        }
    }


    /*

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_CAMERA -> {
                    if(data?.extras?.get("data")!=null) {
                        val bitmap = data?.extras?.get("data") as Bitmap
                        binding.showImageImageView.setImageBitmap(bitmap)
                    }
                }
                REQ_STORAGE->{

                }
            }
        }else{
            Log.d("", "onActivityResult false")
        }
    }

    */



    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(
            activity!!.applicationContext, LoginDatabase::class.java, "database"
        ).allowMainThreadQueries().build()


        var complete_button = view?.findViewById<Button>(R.id.post_complete_button)
        complete_button?.setOnClickListener {
            //태그들
            var direct_tag = input_direct_tag.text.toString()
            var auto_tag = input_auto_tag.text.toString()

            db.TagDao().insertTag(Tag_Info(0, 1,direct_tag)) //포스트 넘 빠져있음
            Toast.makeText(context,"포스트 작성 완료",Toast.LENGTH_SHORT).show()
            toHomeActivity()

        }

    }

    fun toHomeActivity() {
        startActivity(Intent(activity!!.applicationContext, HomeActivity::class.java))
    }

}