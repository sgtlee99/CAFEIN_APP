package signuppack

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.cafein_app.MyInfoChangeActivity
import com.example.cafein_app.R
import com.example.cafein_app.ResultActivity
import kotlinx.android.synthetic.main.survey_fragment6.*
import kotlinx.android.synthetic.main.survey_fragment7.*

class SurveyFragment7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survey_fragment7, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var next = view?.findViewById<Button>(R.id.b)
        var check1_7 = view?.findViewById<RadioButton>(R.id.style_but1)
        var check2_7 = view?.findViewById<RadioButton>(R.id.style_but2)

        check1_7?.setOnClickListener() {
            if (check1_7.isChecked) {
                Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
            }
        }

        check2_7?.setOnClickListener() {
            if (check2_7.isChecked) {
                Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
            }
        }


        next?.setOnClickListener {
            var intent = Intent(context, ResultActivity::class.java)


            if (check1_7 != null) {
                if (check1_7.isChecked) {
                    intent.putExtra("msg", check1_7?.text.toString()
                    ) // chb1 텍스트 값 msg 담아 보냄
                } else if (check2_7 != null) {
                    if (check2_7.isChecked) {
                        intent.putExtra("msg", check2_7?.text.toString())
                    }
                }
            }
            startActivity(intent)
        }
    }
}