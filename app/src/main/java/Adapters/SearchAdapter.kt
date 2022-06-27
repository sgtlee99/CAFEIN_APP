package Adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafein_app.R
import com.example.myapplication1.CardViewAdapter
import com.example.myapplication1.CardViewAdapter2
import com.example.myapplication1.CardView_Info

class SearchAdapter(val itemList: ArrayList<CardView_Info>, var con : Context ): RecyclerView.Adapter<SearchAdapter.ViewHolder>(),
    Filterable {

    var TAG = "CardViewFilterAdapter"
    var filteredCards = ArrayList<CardView_Info>()
    var itemFilter = ItemFilter()

    //아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.board_card_view,parent,false)

        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return filteredCards.size
    }
    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        val cardview_info : CardView_Info = filteredCards[position]
        ////제목, 태그, 이미지, 그룹1추천, 그룹2추천, 그룹3추천, 그룹4추천
        holder.cardview_title.text = cardview_info.title
        holder.cardview_tag.text = cardview_info.tag
        holder.cardview_cafe_img.setImageResource(cardview_info.image)
        holder.cardview_group1_button.text = cardview_info.g1.toString()
        holder.cardview_group2_button.text = cardview_info.g2.toString()
        holder.cardview_group3_button.text = cardview_info.g3.toString()
        holder.cardview_group4_button.text = cardview_info.g4.toString()


//        holder.Image.setImageResource(itemList[position].image)

    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var cardview_title : TextView
        var cardview_tag : TextView
        var cardview_cafe_img : ImageView
        var cardview_group1_button : AppCompatButton
        var cardview_group2_button : AppCompatButton
        var cardview_group3_button : AppCompatButton
        var cardview_group4_button : AppCompatButton

        init {
            cardview_title = itemView.findViewById(R.id.cardview_title)
            cardview_tag = itemView.findViewById(R.id.cardview_tag)
            cardview_cafe_img = itemView.findViewById(R.id.cardview_cafe_img)
            cardview_group1_button = itemView.findViewById(R.id.cardview_group1_button)
            cardview_group2_button = itemView.findViewById(R.id.cardview_group2_button)
            cardview_group3_button = itemView.findViewById(R.id.cardview_group3_button)
            cardview_group4_button = itemView.findViewById(R.id.cardview_group4_button)

            //여기 이벤트 리스너 넣을 수 있음
        }

    }

    init {
        filteredCards.addAll(itemList)
    }

    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence : CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            Log.d(TAG, "charSequence : $charSequence")
            //검색이 필요 없을 경우를 위해 원본 배열을 복제
            val filteredList : ArrayList<CardView_Info> = ArrayList<CardView_Info>()
            //공백제외 아무런 값이 없을 경우 -> 원본배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = itemList
                results.count = itemList.size

                return results
                //공백제외 2글자인 경우 -> 타이틀로만 검색
            } else if (filterString.trim{it <= ' '}.length <= 2) {
                for (cardview_info in itemList) {
                    filteredList.add(cardview_info)
                }
            } else {             //그 외의 경우 (공백제외 2글자 초과) -> 타이틀/전번
                for (cardview_info in itemList) {
                    if (cardview_info.title.contains(filterString) || cardview_info.tag.contains(filterString)) {
                        filteredList.add(cardview_info)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        override fun publishResults(charSequence : CharSequence?, filterResults : FilterResults) {
            filteredCards.clear()
            filteredCards.addAll(filterResults.values as ArrayList<CardView_Info>)
            notifyDataSetChanged()
        }
    }
}
