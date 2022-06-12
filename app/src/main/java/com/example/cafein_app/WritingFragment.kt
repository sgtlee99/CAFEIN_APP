package com.example.cafein_app

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.cafein_app.databinding.FragmentWritingBinding
import kotlinx.android.synthetic.main.fragment_writing.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.jar.Manifest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

// private val GALLERY = 1
// gg
/**
 * A simple [Fragment] subclass.
 * Use the [BoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WritingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val GALLERY = 1

    val REQ_CAMERA = 100
    val REQ_STORAGE = 99

    private var mBinding: FragmentWritingBinding? = null
    private val binding get() = mBinding!!



    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(context, "Grant", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Deny", Toast.LENGTH_SHORT).show()
            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //R.id.btnCamera -> {
        //    requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        //}


        // 오류 수정
        //setContentView(R.layout.fragment_writing)

        // btnGallery.setOnClickListener {
        //     val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        //     intent.setType("image/*")
        //     startActivityForResult(intent,GALLERY)
        // }

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //setContentView(R.layout.fragment_writing)
        //openGallery_button.setOnClickListener {
            //openGallery()
        //}
    }


    //fun initViews() {
    //    binding.btnCamera.setOnClickListener {
    //        openCamera()
    //    }
    //    binding.btnGallery.setOnClickListener {
    //        openGallery()
    //    }
    //}


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var btnOpenGallery = view?.findViewById<Button>(R.id.btnGallery)
        btnOpenGallery?.setOnClickListener {
            openGallery()
            //val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            //intent.setType("image/*")
            //startActivityForResult(intent,GALLERY)
        }
    }


    var realUri: Uri? = null


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
            image = if(Build.VERSION.SDK_INT>27) {
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


    // 버튼 누르면 갤러리 열림
    //override fun onActivityCreated(savedInstanceState: Bundle?) {
    //    super.onActivityCreated(savedInstanceState)

    //    var btnOpenGallery = view?.findViewById<Button>(R.id.btnGallery)
    //    btnOpenGallery?.setOnClickListener {
    //        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
    //        intent.setType("image/*")
    //        startActivityForResult(intent,GALLERY)
    //    }

    //}

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





    // 사진 클릭하면 선택한 사진 보여줌
    //@Override
    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    //    super.onActivityResult(requestCode, resultCode, data)

    //    if( resultCode == Activity.RESULT_OK){
    //        if( requestCode ==  GALLERY)
    //        {
    //            var ImnageData: Uri? = data?.data
                //Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
    //            try {                                              // getContentResolver()
    //               val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
    //                var imageCheckView = view?.findViewById<ImageView>(R.id.showImage_ImageView)
    //                imageCheckView?.setImageBitmap(bitmap)
    //            }
    //            catch (e:Exception)
    //            {
    //                e.printStackTrace()
    //            }
    //        }
    //    }
    //}



    //private fun openGallery() {
        //val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        //intent.setType("image/*")
        //startActivityForResult(intent, OPEN_GALLERY)
    //}

    // 뷰 바인딩 관련코드는 북마크 블로그 참고
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentWritingBinding.inflate(inflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_writing, container, false)

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}