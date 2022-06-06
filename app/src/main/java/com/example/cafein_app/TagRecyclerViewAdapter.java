//package com.example.cafein_app;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//class TagRecyclerViewAdapter extends RecyclerView.Adapter<TagRecyclerViewAdapter.ViewHolder> {
//
//    private String[] mData;
//    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
//
//    TagRecyclerViewAdapter(Context context, String[] data) {
//        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
//    }
//
//    @Override
//    @NonNull
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.tag_items, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.myTextView.setText(mData[position]);
//
////        holder.itemView.setOnClickListener {
////            Toast.makeText(context, "Clicked: ${items.get(position).title}", Toast.LENGTH_SHORT).show()
////            //새 액티비티를 열고 웹뷰를 이용해서 상세보기 페이지를 보여 준다.
////        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.length;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView myTextView;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            myTextView = itemView.findViewById(R.id.info_text);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
//    }
//    String getItem(int id) {
//        return mData[id];
//    }
//
//    void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }
//
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
//
//}
