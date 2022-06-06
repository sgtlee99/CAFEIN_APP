package com.example.cafein_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.CardViewAdapter

class TRecyclerViewAdapter(val tagList : ArrayList<Tag_Info>) : RecyclerView.Adapter<TRecyclerViewAdapter.ViewHolder>() {
    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag_items, parent, false)
        return TRecyclerViewAdapter.ViewHolder(view)
    }
    // (2) 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return tagList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Tag : TextView = itemView.findViewById(R.id.info_text)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tag.text = tagList[position].tag

        holder.itemView.setOnClickListener { itemClickListener?.onItemClick(it,position) }

    }
    //리스너 인터페이스
    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    //외부에서 클릭시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    // setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener: OnItemClickListener

}