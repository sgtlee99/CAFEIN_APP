package signuppack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.cafein_app.R

class SurveyFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survey_fragment3, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var check1_3 = view?.findViewById<RadioButton>(R.id.date_but)
        var check2_3 = view?.findViewById<RadioButton>(R.id.study_but)

        check1_3?.setOnClickListener() {
            if (check1_3.isChecked) {
                Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()

            }
        }

            check2_3?.setOnClickListener() {
                if (check2_3.isChecked) {
                    Toast.makeText(context, "체크되었습니다. ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }