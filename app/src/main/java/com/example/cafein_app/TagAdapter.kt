package com.example.cafein_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TagAdapter (var items : ArrayList<Tag>) : RecyclerView.Adapter<TagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagAdapter.ViewHolder {
        TODO("Not yet implemented")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tag_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TagAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        items.count()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item : Tag) {
            val tagitem_list = itemView.findViewById<TextView>(R.id.tag_text) // 태그 택스트
            tagitem_list.text = item.tag_data
        }
    }

}