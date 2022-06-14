package signuppack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.R

class SurveyActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity4)

        var button = findViewById<Button>(R.id.b)


        button.setOnClickListener {
            var intent = Intent(this, SurveyActivity5::class.java)
            startActivity(intent)
        }
    }
}