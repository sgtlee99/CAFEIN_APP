package com.example.cafein_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var reviewwritingbtn = view?.findViewById<Button>(R.id.btnReviewWriting)
        reviewwritingbtn?.setOnClickListener {
            var intent = Intent(context, ReviewWritingActivity::class.java)
            startActivity(intent)
        }
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
        reviewList.add(Review_Info(R.drawable.friend, "홍길동", R.drawable.cafe_front,"사장님이 친절하고 커피가 맛있어요" ))
        reviewList.add(Review_Info(R.drawable.nasa1, "로켓", R.drawable.cafe_front2,"분위기 좋아요" ))
        reviewList.add(Review_Info(R.drawable.beatle1, "비틀", R.drawable.beatle1,"폭스바겐 비틀은 비틀비틀 가나요?" ))
        reviewList.add(Review_Info(R.drawable.cafe_front3,"김철수",R.drawable.cafe_front3,"여기 커피 직접 볶는 집이에요 강추!"))

//변경될때 알려줌
        ReviewRecyclerAdapter(reviewList).notifyDataSetChanged()

    }
}
