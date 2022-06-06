package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.cafein_app.R
import com.example.myapplication1.CardViewAdapter
import org.w3c.dom.Text

//       프로필사진, 닉네임, 리뷰사진, 포스트
class ReviewRecyclerAdapter(val reviewList: ArrayList<Review_Info>): RecyclerView.Adapter<ReviewRecyclerAdapter.ViewHolder>() {
    // 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_items, parent, false)
        return ViewHolder(view)
    }
    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return reviewList.size
    }
    // View에 내용 입력
    override fun onBindViewHolder(holder: ReviewRecyclerAdapter.ViewHolder, position: Int) {
        holder.profile_Image.setImageResource(reviewList[position].profile_image)
        holder.nickname.text = reviewList[position].nickname
        holder.review_Image.setImageResource(reviewList[position].review_image)
        holder.review_Post.text = reviewList[position].review_post
    }

    // (4) 레이아웃 내 View 연결
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile_Image: ImageView = itemView.findViewById(R.id.review_profile_image)
        val nickname: TextView = itemView.findViewById(R.id.review_nickname)
        val review_Image: ImageView = itemView.findViewById(R.id.review_image)
        val review_Post: TextView = itemView.findViewById(R.id.review_post)
    }
}
