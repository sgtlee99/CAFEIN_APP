package com.example.cafein_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

//        val Adapter = ListAdapter(,UserList)
//        var list_view = view?.findViewById<ListView>(R.id.list_view)
//        list_view.adapter = Adapter
    }
}