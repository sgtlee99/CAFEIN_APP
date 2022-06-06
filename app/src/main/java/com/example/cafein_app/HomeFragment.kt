package com.example.cafein_app

import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafein_app.databinding.FragmentHomeBinding
import com.example.myapplication1.CardViewAdapter
import com.example.myapplication1.CardView_Info

class HomeFragment : Fragment(R.layout.fragment_home) {

    //=============프래그먼트 뷰 바인딩을 위한 작업==============
    //카드뷰를 위한 바인딩
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val itemList = arrayListOf<CardView_Info>()      // 아이템 배열
    val tagList = arrayListOf<Tag_Info>() //태그 배열


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //===================태그====================================
        binding.listViewview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
//        binding.listViewview.adapter = TRecyclerViewAdapter(tagList)
//        TRecyclerViewAdapter(tagList).setItemClickListener(object : TRecyclerViewAdapter.OnItemClickListener {
//            override fun onItemClick(v: View, position: Int) {
//                Toast.makeText(v.context, "Tag", Toast.LENGTH_SHORT).show()
//            }
//        })
        binding.listViewview.adapter = TRecyclerViewAdapter(tagList).apply { setItemClickListener(object : TRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                Toast.makeText(v.context, "Tag", Toast.LENGTH_SHORT).show()

            }

        }) }
//            //=============카드 뷰 ====================================
        binding.cardviewRecyclerviewview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        binding.cardviewRecyclerviewview.adapter = CardViewAdapter(itemList)
//        CardViewAdapter(itemList).setItemClickListener(object : CardViewAdapter.OnItemClickListener {
//            override fun onClick(v: View, position: Int) {
//                Toast.makeText(v.context, "cardview", Toast.LENGTH_SHORT).show()
////                var intent = Intent(context, BoardFragmentActivity::class.java)
////                startActivity(intent)
//            }
//        })
        binding.cardviewRecyclerviewview.adapter = CardViewAdapter(itemList).apply { setItemClickListener(object : CardViewAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Toast.makeText(v.context, "cardview", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, BoardFragmentActivity::class.java)
                startActivity(intent)
            }
        })}

//        // 아이템 추가
        itemList.add(CardView_Info("오타니", "#안녕하세요 #반갑습니다", R.drawable.friend, 3, 2, 5, 4))
        itemList.add(CardView_Info("헬로우", "#태그1 #태그2", R.drawable.nasa1, 44, 0, 8, 6))
        itemList.add(CardView_Info("자동차", "#무슨사진 #이더라", R.drawable.cafe_front2, 50, 5, 5, 12))
        itemList.add(CardView_Info("오타니", "#창백한 #푸른 #눈", R.drawable.cafe_front3, 78, 9, 5, 99))
//태그 아이템 추가
        tagList.add(Tag_Info("Tag"))
        tagList.add(Tag_Info("Tag"))
        tagList.add(Tag_Info("Tag"))
        tagList.add(Tag_Info("Tag"))
        tagList.add(Tag_Info("Tag"))
        tagList.add(Tag_Info("Tag"))
        TRecyclerViewAdapter(tagList).notifyDataSetChanged()
        // 리스트가 변경됨을 어댑터에 알림
        CardViewAdapter(itemList).notifyDataSetChanged()
    }

}