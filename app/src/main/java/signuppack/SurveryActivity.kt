package signuppack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.Nullable
import com.example.cafein_app.R
import com.example.cafein_app.ResultActivity
import kotlinx.android.synthetic.main.activity_survery.*

class SurveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survery)


//        var scrollView = findViewById<ScrollView>(R.id.scrollView)
//        var rb1_1 = findViewById<RadioButton>(R.id.rb1_1)
//        var rb5_2 = findViewById<RadioButton>(R.id.rb5_2)
//
//        scrollView.scrollTo(0, rb5_2.bottom)
//        scrollView.scrollTo(0, rb1_1.top)

        var btn = findViewById<Button>(R.id.pass_btn)
        var check1_1 = findViewById<RadioButton>(R.id.rb1_1)
        var check1_2 = findViewById<RadioButton>(R.id.rb1_2)
        var check2_1 = findViewById<RadioButton>(R.id.rb2_1)
        var check2_2 = findViewById<RadioButton>(R.id.rb2_2)
        var check3_1 = findViewById<RadioButton>(R.id.rb3_1)
        var check3_2 = findViewById<RadioButton>(R.id.rb3_2)
        var check4_1 = findViewById<RadioButton>(R.id.rb4_1)
        var check4_2 = findViewById<RadioButton>(R.id.rb4_2)
        var check5_1 = findViewById<RadioButton>(R.id.rb5_1)
        var check5_2 = findViewById<RadioButton>(R.id.rb5_2)
        var check6_1 = findViewById<RadioButton>(R.id.rb6_1)
        var check6_2 = findViewById<RadioButton>(R.id.rb6_2)

        //회원가입정보 거쳐갑니다
        var id : String? = intent.getStringExtra("signup_id")
        var pw : String? = intent.getStringExtra("signup_pw")
        var nick : String? = intent.getStringExtra("signup_nick")
        var email : String? = intent.getStringExtra("signup_email")
        var com : String? = intent.getStringExtra("signup_owner")
        var sex : String? = intent.getStringExtra("signup_sex")
        var age : Int? = intent.getIntExtra("signup_age",20)



        btn.setOnClickListener {
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("signup_id", id)
            intent.putExtra("signup_pw", pw)
            intent.putExtra("signup_nick", nick)
            intent.putExtra("signup_email", email)
            intent.putExtra("signup_owner", com)
            intent.putExtra("signup_sex", sex)
            intent.putExtra("signup_age", age)

            if (check1_1 != null) {
                if (check1_1.isChecked) {
                    intent.putExtra("msg", check1_1.text.toString()) // chb1 텍스트 값 msg 담아 보냄
                } else if (check1_2 != null) {
                    if (check1_2.isChecked) {
                        intent.putExtra("msg", check1_2.text.toString())
                    }
                }

                if (check2_1 != null) {
                    if (check2_1.isChecked) {
                        intent.putExtra("msg1", check2_1.text.toString())
                    } else if (check2_2 != null) {
                        if (check2_2.isChecked) {
                            intent.putExtra("msg1", check2_2.text.toString())
                        }
                    }

                    if (check3_1 != null) {
                        if (check3_1.isChecked) {
                            intent.putExtra("msg2", check3_1.text.toString())
                        } else if (check3_2 != null) {
                            if (check3_2.isChecked) {
                                intent.putExtra("msg2", check3_2.text.toString())
                            }
                        }

                        if (check4_1 != null) {
                            if (check4_1.isChecked) {
                                intent.putExtra("msg3", check4_1.text.toString())
                            } else if (check4_2 != null) {
                                if (check4_2.isChecked) {
                                    intent.putExtra("msg3", check4_2.text.toString())
                                }
                            }

                            if (check5_1 != null) {
                                if (check5_1.isChecked) {
                                    intent.putExtra("msg4", check5_1.text.toString())
                                } else if (check5_2 != null) {
                                    if (check5_2.isChecked) {
                                        intent.putExtra("msg4", check5_2.text.toString())
                                    }
                                }

                                if (check6_1 != null) {
                                    if (check6_1.isChecked) {
                                        intent.putExtra("msg5", check6_1.text.toString())
                                    } else if (check6_2 != null) {
                                        if (check6_2.isChecked) {
                                            intent.putExtra("msg5", check6_2.text.toString())
                                        }
                                    }
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
        }

    }

//    fun data_shoot(
//        id: String,
//        pw: String,
//        nickname: String,
//        email: String,
//        owner: Boolean,
//        sex: Boolean,
//        age: Int
//    ) {
//        var intent = Intent(this, ResultActivity::class.java)
//        intent.putExtra("signup_id", id)
//        intent.putExtra("signup_pw", pw)
//        intent.putExtra("signup_nick", nickname)
//        intent.putExtra("signup_email", email)
//        intent.putExtra("signup_owner", owner)
//        intent.putExtra("signup_sex", sex)
//        intent.putExtra("signup_age", age)
//    }
}