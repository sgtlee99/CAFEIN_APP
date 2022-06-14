package signuppack

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cafein_app.R
import com.example.cafein_app.ResultActivity

class SurveyActivity7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survey_activity7, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var button = view?.findViewById<Button>(R.id.btn_result)
        button?.setOnClickListener {
            var intent = Intent(context, ResultActivity::class.java)
            startActivity(intent)
        }

 //       button?.setOnClickListener {
 //           val intent = Intent(context, ResultActivity::class.java)
//            intent.putExtra("msg1", chb1.text.toString()) // chb1 텍스트 값 msg 담아 보냄
//            intent.putExtra("msg2", chb2.text.toString())
//            intent.putExtra("msg3", chb3.text.toString())
 //           startActivity(intent)
  //      }
    }
}