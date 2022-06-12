package com.example.cafein_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafein_app.databinding.FragmentBoardreviewBinding
import com.example.cafein_app.databinding.FragmentHomeBinding
import com.example.myapplication1.CardViewAdapter
import com.example.myapplication1.CardView_Info

class ReviewBoardFragment : Fragment(R.layout.fragment_boardreview) {
    //=============프래그먼트 뷰 바인딩을 위한 작업==============
    //카드뷰를 위한 바인딩
    private var _binding: FragmentBoardreviewBinding? = null
    private val binding get() = _binding!!

    val reviewList = arrayListOf<Review_Info>()      // 리뷰글 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_boardreview, container, false)
        _binding = FragmentBoardreviewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //리뷰글 어댑터 연결
        binding.reviewRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        /*
        binding.cardviewRecyclerviewview.adapter = CardViewAdapter(itemList).apply { setItemClickListener(object : CardViewAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Toast.makeText(v.context, "cardview", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, BoardFragmentActivity::class.java)
                startActivity(intent)
            }
        })}
         */
        binding.reviewRecyclerView.adapter = ReviewRecyclerAdapter(reviewList)
        //리뷰글 추가 - 데이터베이스 연결필요
        reviewList.add(Review_Info(R.drawable.friend, "오타니", R.drawable.friend,"안녕하세요 LA 에인절스 소속 오타니 입니다" ))
        reviewList.add(Review_Info(R.drawable.nasa1, "SLS", R.drawable.nasa1,"화성... 아니 달 갈끄니까아앗~~!" ))
        reviewList.add(Review_Info(R.drawable.beatle1, "비틀", R.drawable.beatle1,"폭스바겐 비틀은 비틀비틀 가나요?" ))
        reviewList.add(Review_Info(R.drawable.cafe_front3,"카페돌이",R.drawable.cafe_front2,"커피 너무 맛있어요 서비스도 좋아요"))

//변경될때 알려줌
        ReviewRecyclerAdapter(reviewList).notifyDataSetChanged()

    }
}
