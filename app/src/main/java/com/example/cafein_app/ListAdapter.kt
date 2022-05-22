package com.example.cafein_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class ListAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_user, null)
        val Name = view.findViewById<TextView>(R.id.name_tv)
        val Email = view.findViewById<TextView>(R.id.email_tv)
        val Content = view.findViewById<TextView>(R.id.content_tv)

        val user = UserList[position]

        Name.text = user.name
        Email.text = user.email
        Content.text = user.content

        return view
    }
    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position : Int): Long {
        return 0
    }
    override fun getCount(): Int {
        return UserList.size
    }
}