package signuppack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.R

class SurveyActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity7)

        var button = findViewById<Button>(R.id.b)
        var style1 = findViewById<CheckBox>(R.id.style_cb1)
        var style2 = findViewById<CheckBox>(R.id.style_cb2)


        button.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
//            if (style1.isChecked) {
//                intent.putExtra("msg3", style1.text.toString()) // chb1 텍스트 값 msg 담아 보냄
//            } else if (style2.isChecked) {
//                intent.putExtra("msg3", style2.text.toString())
//            }
            startActivity(intent)
        }
    }
}