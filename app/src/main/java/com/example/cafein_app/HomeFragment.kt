package com.example.cafein_app

import DB_Dao_Helper.LoginDatabase
import DB_Dao_Helper.Tag_Info
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.cafein_app.databinding.FragmentHomeBinding
import com.example.myapplication1.CardViewAdapter
import com.example.myapplication1.CardView_Info
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    //=============프래그먼트 뷰 바인딩을 위한 작업==============
    //카드뷰를 위한 바인딩
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val itemList = arrayListOf<CardView_Info>()      // 아이템 배열


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        // contextmenu 지정
        registerForContextMenu(binding.cardviewRecyclerviewview)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        tagDb = context?.let { LoginDatabase.getInstance(it) }
//        tagDb = LoginDatabase.getInstance(context)

//        var r = Runnable {
//            //데이터를 읽고 쓸때는 쓰레드 사용
//            tagList = tagDb?.TagDao()?.tag_getAll()!!
//        }
//        val thread = Thread(r)
//        thread.start()

        // db 연결
        val db = Room.databaseBuilder(
            activity!!.applicationContext, LoginDatabase::class.java, "database"
        ).allowMainThreadQueries().build()


        var tagList = listOf<Tag_Info>(
            Tag_Info(0,1,"Tag1"),
            Tag_Info(0,1,"Tag2"),
            Tag_Info(0,1,"Tag3"),
            Tag_Info(0,1,"Tag4"),
            Tag_Info(0,1,"Tag5"),
            Tag_Info(0,1,"Tag6"),
            Tag_Info(0,1,"Tag7"),
            Tag_Info(0,1,"Tag8"),
            Tag_Info(0,1,"Tag9"),
            Tag_Info(0,1,"Tag10"),
        )

        db.TagDao().tag_getAll().observe(this, Observer { todos->
            tagList = todos
        })


        //===================태그====================================
        binding.listViewview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.listViewview.adapter = TRecyclerViewAdapter(tagList).apply {
            setItemClickListener(object : TRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Toast.makeText(v.context, "Tag", Toast.LENGTH_SHORT).show()
//                    Toast.makeText(v.context,tagList.toString(),Toast.LENGTH_LONG).show()
                }
            })
        }
//            //=============카드 뷰 ====================================
        binding.cardviewRecyclerviewview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.cardviewRecyclerviewview.adapter = CardViewAdapter(itemList).apply {
            setItemClickListener(object : CardViewAdapter.OnItemClickListener {
                override fun onClick(v: View, position: Int) {
                    Toast.makeText(v.context, "cardview", Toast.LENGTH_SHORT).show()
                    var intent = Intent(context, BoardFragmentActivity::class.java)
                    startActivity(intent)
                }
            })
        }


        upListener(binding.cardviewRecyclerviewview)


//        // 아이템 추가
        itemList.add(CardView_Info("영진카페", "#복현동 #아메리카노", R.drawable.cafe_front, 3, 2, 5, 4))
        itemList.add(CardView_Info("로켓", "#태그1 #태그2", R.drawable.nasa1, 44, 0, 8, 6))
        itemList.add(CardView_Info("자동차", "#무슨사진 #이더라", R.drawable.beatle1, 50, 5, 5, 12))
        itemList.add(CardView_Info("카페테스트2", "#tag1 #tag2", R.drawable.cafe_front3, 78, 9, 5, 99))
//태그 아이템 추가

//        tagtag.text = tagList.toString()

//        tagList.add(Tag_Info(1,0,"Tag1"))


//        var tag_text = db.TagDao().

//        val tagform = Tag_Info(1,"") //Contacts 생성
//        db.TagDao().insertTag(tagform)
//        var get_postnum = db.TagDao().getPostNum()
//        var get_tag= db.TagDao().getTag()
//        var get_tagnum = db.TagDao().getTagNum()
//        tagList.add(Tag_Info(get_postnum,get_tag)) //리스트추가

//        tagList.add(db.TagDao().tag_getAll().)
        // 리스트가 변경됨을 어댑터에 알림
        TRecyclerViewAdapter(tagList).notifyDataSetChanged()
        CardViewAdapter(itemList).notifyDataSetChanged()


    }

    private fun upListener(view: RecyclerView?) {

        btnUp.setOnClickListener {
            view?.smoothScrollToPosition(0)
        }

    }

}