package signuppack

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.LoginActivity
import com.example.cafein_app.R
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.signup_activity.*
//회원가입 과정
//기초 정보 입력 (아이디, 비번, 닉네임 등) -> 설문조사 ->
class SignupActivity : AppCompatActivity() {
    val TAG : String = "SIGNUP"
    var isExitBlank = false
    var isPWSame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)


        //설문조사로 이동
        var signupnextbutton = findViewById<Button>(R.id.signuppage_NextButton)

        signupnextbutton.setOnClickListener {
            //버튼이 눌렸다는걸 로그 전송
            Log.d(TAG, "회원버튼 -> 설문지 버튼 클릭")
            //====회원가입 수행====
            //아이디 비밀번호 비밀번호확인 닉네임 점주(스위치) 성별(체크박스)
            //editText에 적힌 값을 받아옴
            val id = input_signupID.text.toString()
            val pw = input_signupPW.text.toString()
            val pw_cf = input_signupPW_confirm.text.toString()
            val nick = input_signipNickname.text.toString()

            //val owner
            //val sex

            //사용자가 입력항목을 다 채우지 않은 경우
            if(id.isEmpty() || pw.isEmpty() || pw_cf.isEmpty() || nick.isEmpty()) {
                isExitBlank = true
            } else {
                if(pw == pw_cf) {
                    isPWSame = true
                }
            }

            if(!isExitBlank && isPWSame) { //입력항목이 다 채워진경우 && 비밀번호와 비밀번호 확인 일치
                //회원가입 성공 토스트 메시지
                Toast.makeText(this, "${nick}님 회원가입 성공입니다.", Toast.LENGTH_SHORT).show()

                val sharedPreference = getSharedPreferences("fill name", Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()

                editor.putString("id", id)
                editor.putString("pw", pw)
                editor.putString("nickname", nick)

                editor.apply()

                //로그인 화면으로 이동
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                //다음 설문조사로 이동
//                var intent = Intent(this, ViewPager2::class.java)
//                startActivity(intent)
            } else {
                //상태에따른 다이얼로그 띄우기
                if(isExitBlank) { //작성안한 곳이 있을 경우
                    dialog("blank") //다이얼로그 함수 만들어서 사용
                } else if (!isPWSame) {//비밀번호가 확인 되지 않은경우
                    dialog("not same")
                }
            }
        }
    }

    fun dialog(type : String) {
        val dialog = AlertDialog.Builder(this)


        if(type.equals("blank")) {  //작성안한 곳이 있을 경우
            dialog.setTitle("회원가입 실패!")
            dialog.setMessage("입력하지 않은 항목이 있습니다.")
        } else if (type.equals("not same")){    //비밀번호가 확인 되지 않은경우
            dialog.setTitle("회원가입 실패!")
            dialog.setMessage("비밀번호가 다릅니다.")
        }

        val dialog_listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog : DialogInterface?, which : Int) {
                when(which) {
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "다이얼로그")
                }
            }
        }
        dialog.setPositiveButton("확인", dialog_listener)
        dialog.show()

    }
}