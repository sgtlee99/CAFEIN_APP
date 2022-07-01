package signuppack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cafein_app.R

class SurveyFragment6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survey_fragment6, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var check1_6 = view?.findViewById<RadioButton>(R.id.sns_but1)
        var check2_6 = view?.findViewById<RadioButton>(R.id.sns_but2)

        check1_6?.setOnClickListener() {
            if (check1_6.isChecked) {
                Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
            }
        }

            check2_6?.setOnClickListener() {
                if (check2_6.isChecked) {
                    Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
                }
            }

        }
    }