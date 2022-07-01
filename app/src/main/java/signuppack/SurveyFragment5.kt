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

class SurveyFragment5 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survey_fragment5, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var check1 = view?.findViewById<RadioButton>(R.id.de_but1)
        var check2 = view?.findViewById<RadioButton>(R.id.de_but2)

        check1?.setOnClickListener() {
            if (check1.isChecked) {
                Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
            }
        }

            check2?.setOnClickListener() {
                if (check2.isChecked) {
                    Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }