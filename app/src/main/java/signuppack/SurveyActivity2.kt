package signuppack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.R

class SurveyActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity2)

        var button = findViewById<Button>(R.id.b)


        button.setOnClickListener {
            var intent = Intent(this, SurveyActivity3::class.java)
            startActivity(intent)
        }
    }
}