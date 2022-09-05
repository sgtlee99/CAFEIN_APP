package com.example.cafein_app

import DB_Dao_Helper.Login_User
import DB_Dao_Helper.Post_Write
import DB_Dao_Helper.Register_User
import DB_Dao_Helper.RetrofitBuilder
import android.Manifest
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
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.example.cafein_app.databinding.FragmentWritingBinding
import kotlinx.android.synthetic.main.fragment_writing.*
import kotlinx.android.synthetic.main.fragment_writing.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.text.SimpleDateFormat

class WritingFragment : Fragment() {

    val loged_viewModel by activityViewModels<LoginViewModel>()
    var add_user_info : String? =""

    private val GALLERY = 1

    val REQ_CAMERA = 100
    val REQ_STORAGE = 99

    var realUri: Uri? = null

    private var mBinding: FragmentWritingBinding? = null
    private val binding get() = mBinding!!

    // 권한
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
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)  // 권한
            openCamera()
        }
    }


    // var realUri: Uri? = null

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        createImageUri(newFileName(), "image/jpg")?.let {
            realUri = it
            intent.putExtra(MediaStore.EXTRA_OUTPUT, realUri)
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
        values.put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType)
        return binding.root.context.contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            values
        )
    }


    fun newFileName(): String {
        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "$filename.jpg"
    }

    fun loadBitmap(photoUri: Uri): Bitmap? {
        var image: Bitmap? = null
        try {
            image = if (Build.VERSION.SDK_INT > 27) {     // API버전별 이미지 처리
                val source: ImageDecoder.Source =
                    ImageDecoder.createSource(binding.root.context.contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(binding.root.context.contentResolver, photoUri)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
        //변수 image에 bitmap 형식으로 이미지가 저장되나?
    }


    // 뷰 바인딩 관련코드는 북마크 블로그 참고
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentWritingBinding.inflate(inflater, container, false)

        val view = inflater.inflate(R.layout.fragment_writing, container, false)


        return binding.root
        // return view
        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_CAMERA -> {
                    realUri?.let {
                        val bitmap = loadBitmap(it)
                        binding.showImageImageView.setImageBitmap(bitmap)
                        realUri = null
                    }
                }
                REQ_STORAGE -> {
                    data?.data?.let {
                        binding.showImageImageView.setImageURI(it)
                    }
                }
            }
        } else {
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
//글 작성 완료 시
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 자동태그
        var tag_btn: Button = view?.findViewById(R.id.tagBtn) // 추출버튼
        var post: EditText = view?.findViewById(R.id.input_post_contents) // 내용입력
        var tag_complete: TextView = view?.findViewById(R.id.input_auto_tag) // 자동태그 텍스트뷰

        tag_btn.setOnClickListener {
            val tags = getTags(post.text.toString())
            var result = ""

            tags.forEach { tag ->
                result += "${tag.value} "
            }

            if (result == "") result = "태그가 없습니다"

            tag_complete.text = result
        }
        //글쓰기 완료 버튼을 눌렀을 때
        var complete_button = view?.findViewById<Button>(R.id.post_complete_button)
        complete_button?.setOnClickListener {

            var post_up = Post_Write()


            var title = input_post_title.text.toString()    //제목
            //사진이 들어가야함
            var contents = input_post_contents.text.toString()  //내용
            //태그들
            var direct_tag = input_direct_tag.text.toString()
            var auto_tag = input_auto_tag.text.toString()
            var tags = "$direct_tag $auto_tag"   //태그를 합쳐서 문자열 형태로 한번에 처리

            post_up.title = title
            //사진 들어가야 함
            post_up.content = contents
            post_up.tag = tags


            //유저 아이디 실어서 보냄
//            up_user = arguments?.getString("loged_user")
            add_user_info = loged_viewModel.preferences

            //글작성 완료
            Post_Upload(post_up) //모아서 보냄
            Log.d("SHOW_TEST_RESULT", "$title : $contents : $tags : $add_user_info")

//            Toast.makeText(context, "포스트 작성 완료", Toast.LENGTH_SHORT).show()
//            toHomeActivity()
        }

    }
//    fun add_up_user(string : String) {
//
//    }
    private fun Post_Upload(post_up: Post_Write) {
        val call = RetrofitBuilder.post_api.getPostResponse(post_up)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    Log.d("SHOW_RESPONSE : ", response.body().toString())
                    Toast.makeText(context, "[글 작성 완료]", Toast.LENGTH_SHORT).show()
                    toHomeActivity()
                } else {
                    Log.d("SHOW_RESPONSE : ", "POST UPLOAD FAILURE")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("SHOW_CONNECTION FAILURE : ", t.localizedMessage)
            }
        })
    }


    private fun getTags(text: String): Sequence<MatchResult> {
        /*
        https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/
         */
        val pattern = """#([^#\s]+)""" // 태그 추출 정규식
        val regex = pattern.toRegex()
        val matches = regex.findAll(text)

        return matches
    }


    fun toHomeActivity() {
        startActivity(Intent(activity!!.applicationContext, HomeActivity::class.java))
    }

}