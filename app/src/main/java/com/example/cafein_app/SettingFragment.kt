package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SettingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var myinfo = view?.findViewById<Button>(R.id.mypage_InfoChangeButton)
        myinfo?.setOnClickListener {
            var intent = Intent(context, MyInfoChangeActivity::class.java)
            startActivity(intent)
        }

        var likecafe = view?.findViewById<Button>(R.id.mypage_LikeCafeButton)
        likecafe?.setOnClickListener {
            var intent = Intent(context, LikeCafeActivity::class.java)
            startActivity(intent)
        }

        var logout = view?.findViewById<Button>(R.id.mypage_LogoutButton)
        logout?.setOnClickListener {
            var intent = Intent(context, OriginActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }
}