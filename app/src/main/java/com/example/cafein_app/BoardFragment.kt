package com.example.cafein_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_boartview.*

class BoardFragment : Fragment() {

    var likePost : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boartview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var likebutton : ImageButton = view!!.findViewById(R.id.post_likebutton)
        likebutton.setOnClickListener {
            if(likebutton.isSelected) {
                likebutton.setImageResource(R.drawable.likebuttonunselect)
                likePost = true
            } else {
                likebutton.setImageResource(R.drawable.likebuttonselect)
                likePost = false
            }
            likebutton.setSelected(!likebutton.isSelected())
        }
    }

}