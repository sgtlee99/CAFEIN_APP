package signuppack

import DB_Dao_Helper.LoginDatabase
import DB_Dao_Helper.USER
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.example.cafein_app.LoginActivity
import com.example.cafein_app.R
import com.example.cafein_app.ResultActivity
import kotlinx.android.synthetic.main.signup_activity.*

//회원가입 과정
//기초 정보 입력 (아이디, 비번, 닉네임 등) -> 설문조사 -> 설문조사 결과창에서 모든 정보를 취합하여 웹서버로 전송함
class SignupActivity : AppCompatActivity() {
    val TAG: String = "SIGNUP"

    var isExitBlank = false
    var isPWSame = false

    var isOwner = false
    var isMale = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        //DB사용
        val db = Room.databaseBuilder(
            applicationContext, LoginDatabase::class.java, "database"
        ).allowMainThreadQueries().build()


        //스위치가 on 일때 => 점주일때 => true
        switch_owner.setOnCheckedChangeListener { compoundButton, b ->
            isOwner = switch_owner.isChecked
        }
        //라디오 버튼에 따라 성별 boolean 값 변경 : 남 -> ture
        gender_group.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.male_radioButton -> isMale = true
                R.id.female_radioButton -> isMale = false
            }
        }
        //seekbar로 나이 입력
        var age = 0
        var age_bar: SeekBar = findViewById(R.id.age_seekbar)
        age_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                age_View.text = p1.toString()
                age = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        //회원가입
        //Next 버튼 이벤트
        signuppage_NextButton.setOnClickListener {
            //버튼이 눌렸다는걸 로그 전송
            Log.d(TAG, "회원버튼 -> 설문지 버튼 클릭")
            var id: String = input_signupID.text.toString()
            var pw: String = input_signupPW.text.toString()
            var pw_check: String = input_signupPW_confirm.text.toString()
            var nick: String = input_signupNickname.text.toString()
            var email: String = input_signupEmail.text.toString()

            //사용자가 입력항목을 다 채우지 않은 경우
            if ((pw != pw_check) || id.isEmpty() || nick.isEmpty() || email.isEmpty()) {
                dialog("blank")
            } else {
                Toast.makeText(this, "추천을 위한 설문조사를 시작합니다", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, SurveryActivity::class.java)
                intent.putExtra("signup_id", id)
                intent.putExtra("signup_pw", pw)
                intent.putExtra("signup_nick", nick)
                intent.putExtra("signup_email", email)
                intent.putExtra("signup_owner", isOwner)
                intent.putExtra("signup_sex", isMale)
                intent.putExtra("signup_age", age)
                startActivity(intent)
            }
        }
    }

    fun dialog(type: String) {
        val dialog = AlertDialog.Builder(this)
        if (type.equals("blank")) {  //작성안한 곳이 있을 경우
            dialog.setTitle("회원가입 실패!")
            dialog.setMessage("입력하지 않은 항목이 있습니다.")
        } else if (type.equals("not same")) {    //비밀번호가 확인 되지 않은경우
            dialog.setTitle("회원가입 실패!")
            dialog.setMessage("비밀번호가 다릅니다.")
        }

        val dialog_listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "다이얼로그")
                }
            }
        }
        dialog.setPositiveButton("확인", dialog_listener)
        dialog.show()
    }




}