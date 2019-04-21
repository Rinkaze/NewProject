package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.bean.WechatBean;
import com.jiyun.day03.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/4/18.
 */

public class RecWechatAdapter extends RecyclerView.Adapter<RecWechatAdapter.ViewHolder> {

    private Context context;
    private List<WechatBean.NewslistEntity> list;

    public RecWechatAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<WechatBean.NewslistEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecWechatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.wechat_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecWechatAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getPicUrl()).into(holder.img);
        holder.title.setText(list.get(position).getTitle());
        holder.author.setText(list.get(position).getDescription());
        holder.date.setText(list.get(position).getCtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView author;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.we_img);
            title = itemView.findViewById(R.id.we_title);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
        }
    }
}
