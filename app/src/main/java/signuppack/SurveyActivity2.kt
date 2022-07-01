package signuppack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.cafein_app.R
import kotlinx.android.synthetic.main.activity_survey2.*


class SurveyActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)

        s2_cb1.setOnClickListener() {
            if (s2_cb1.isChecked) {
                Toast.makeText(this, "체크되었습니다. ", Toast.LENGTH_LONG).show()
                nextSurvey_left()
            }
        }
        s2_cb2.setOnClickListener() {
            if (s2_cb2.isChecked) {
                Toast.makeText(this, "체크되었습니다. ", Toast.LENGTH_LONG).show()
                nextSurvey_right()
            }
        }
    }

    fun nextSurvey_left() {
        var intent = Intent(this, SurveyActivity3::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
    }

    fun nextSurvey_right() {
        var intent = Intent(this, SurveyActivity3::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
    }
}