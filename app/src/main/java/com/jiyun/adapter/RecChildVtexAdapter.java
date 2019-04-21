package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.bean.VtexDataBean;
import com.jiyun.day03.R;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/19.
 */

public class RecChildVtexAdapter extends RecyclerView.Adapter<RecChildVtexAdapter.ViewHolder> {

    private Context context;
    private ArrayList<VtexDataBean> list;

    public RecChildVtexAdapter(Context context, ArrayList<VtexDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_child_vtex,null));
    }

    private static final String TAG = "RecChildVtexAdapter";
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VtexDataBean dataBean = list.get(position);
//        Log.e(TAG, "onBindViewHolder:img = "+dataBean.getImg_src());
        Glide.with(context).load(dataBean.getImg_src().replace("//","https://")).into(holder.img);
        holder.title.setText(dataBean.getTitle());
        if (dataBean.getFromUser() != null){
            holder.fromUser.setText("  ·  最后回复来自: " + dataBean.getFromUser());
        }
        holder.commentCount.setText(dataBean.getComment_count());
        holder.secTab.setText(dataBean.getSecTab());
        holder.author.setText(dataBean.getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView author;
        TextView secTab;
        TextView commentCount;
        TextView fromUser;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            author = itemView.findViewById(R.id.author);
            secTab = itemView.findViewById(R.id.secTab);
            commentCount = itemView.findViewById(R.id.comment_count);
            fromUser = itemView.findViewById(R.id.from_user);
            title = itemView.findViewById(R.id.title);
        }
    }
}
