package signuppack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cafein_app.R

class SurveyActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity1)


        var seekBar = findViewById<SeekBar>(R.id.seekBar)
        var et_age = findViewById<TextView>(R.id.age)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                et_age.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        var button = findViewById<Button>(R.id.b)
        button.setOnClickListener {
            var intent = Intent(this, SurveyActivity2::class.java)
            startActivity(intent)
        }
    }
}