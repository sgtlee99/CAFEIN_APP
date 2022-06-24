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

class SearchAdapter(private val itemList: ArrayList<CardView_Info>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>(),
    Filterable {


    var TAG = "SearchAdapter"

//    var filteredPersons = ArrayList<CardView_Info>()
    var filteredTexts = ArrayList<CardView_Info>()

    var itemFilter = ItemFilter()


    // 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_card_view, parent, false)
        return ViewHolder(view)
    }
    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }
    // View에 내용 입력
    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {

        val cardinfo: CardView_Info = filteredTexts[position]

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


    //-- filter
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<CardView_Info> = ArrayList<CardView_Info>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = itemList
                results.count = itemList.size

                return results
                //공백제외 2글자 이인 경우 -> 이름으로만 검색
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (cardinfo in itemList) {
                    if (cardinfo.title.contains(filterString)) {
                        filteredList.add(cardinfo)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과) -> 이름/전화번호로 검색
            } else {
                for (cardinfo in itemList) {
                    if (cardinfo.title.contains(filterString) || cardinfo.tag.contains(filterString)) {
                        filteredList.add(cardinfo)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

//        fun setAdapter(){
//            //리사이클러뷰에 리사이클러뷰 어댑터 부착
//            rv_phone_book.layoutManager = LinearLayoutManager(this)
//            phoneBookListAdapter = PhoneBookListAdapter(persons, this)
//            rv_phone_book.adapter = phoneBookListAdapter
//        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredTexts.clear()
            filteredTexts.addAll(filterResults.values as ArrayList<CardView_Info>)
            notifyDataSetChanged()
        }
    }


}
//
//class SearchAdapter(var persons: ArrayList<CardView_Info>, var con: Context) :
//    RecyclerView.Adapter<SearchAdapter.ViewHolder>(), Filterable {
//
//}