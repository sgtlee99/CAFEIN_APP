package com.example.cafein_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    lateinit var tagAdpater : RecyclerView
    var tagarr = arrayListOf<Tag>(
        Tag("hello"),
        Tag("hello2"),
        Tag("hello3"),
        Tag("hello4"),
        Tag("hello5"),
        Tag("hello6"),
        Tag("hello7"),
    )

    var UserList = arrayListOf<User>(
        User("심효근","shimhg02@naver.com","아령하세요잇!"),
        User("박채연","asdf@naver.com","할말이 없다"),
        User("박서연","qwerqr2@naver.com","ㄷ"),
        User("박태욱","ㅁㄴㅇㄹㅁㄴㅇㄹㅁㄴㅇㄹ@naver.com","ㅁㄴㅇㄹ"),
        User("김민식","qwer2@naver.com","ㅇㅁㄴㄹ!"),
        User("이소명","shㅇㄹ@naver.com","아령dsafsdf!"),
        User("한규언","shiㅁㄴㅇㄹ@naver.com","afsdf!"),
        User("정빈","shi@naver.com","ㅁㄴㅇㄹ"),
        User("김태양","sㅁㄴㅇㄹㅁㅇㄴㄹaver.com","아ㅇ잇!")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //리사이클러뷰 태그
//        val Adapter = TagAdapter(this, tagList)
//        var tag_listview = view?.findViewById<ListView>(R.id.tag_listview)
//        tag_listview?.adapter = Adapter
        //앱바 변경 코드 (미완성)
        // ActionBar actionbar = ((HomeActivity)getActivity()).getSupportActionBar();
        // actionBar.setTitle("HOME");
        // actionBar.setDisplayHomeAsUpEnabled(false);
        //===========================================
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        tagAdpater = view?.findViewById(R.id.tag_listview)
//        tagAdpater?.adapter = TagAdapter(tagarr)

        val Adapter = ListAdapter(,UserList)
        var list_view = view?.findViewById<ListView>(R.id.list_view)
        list_view.adapter = Adapter
    }
}