package com.example.myapplication1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.cafein_app.R
import java.util.ArrayList


class CardViewAdapter(val itemList: ArrayList<CardView_Info>): RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {

    // 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_card_view, parent, false)
        return ViewHolder(view)
    }
    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }
    // View에 내용 입력
    override fun onBindViewHolder(holder: CardViewAdapter.ViewHolder, position: Int) {
        holder.Title.text = itemList[position].title
        holder.Tag.text = itemList[position].tag
        holder.Image.setImageResource(itemList[position].image)
        holder.G1.text = itemList[position].g1.toString()
        holder.G2.text = itemList[position].g2.toString()
        holder.G3.text = itemList[position].g3.toString()
        holder.G4.text = itemList[position].g4.toString()

        // 리스트 내 항목 클릭 시 onClick() 호출
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    // (4) 레이아웃 내 View 연결
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val Title : TextView = itemView.findViewById(R.id.cardview_title)
        val Tag : TextView= itemView.findViewById(R.id.cardview_tag)
        val Image : ImageView = itemView.findViewById(R.id.cardview_cafe_img)
        val G1 : AppCompatButton= itemView.findViewById(R.id.cardview_group1_button)
        val G2 : AppCompatButton= itemView.findViewById(R.id.cardview_group2_button)
        val G3 : AppCompatButton= itemView.findViewById(R.id.cardview_group3_button)
        val G4 : AppCompatButton= itemView.findViewById(R.id.cardview_group4_button)

    }
    //리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)

    }

    //외부에서 클릭시 이벤트 설정
    fun setItemClickListener(onItemClickListener: CardViewAdapter.OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener: CardViewAdapter.OnItemClickListener
}
