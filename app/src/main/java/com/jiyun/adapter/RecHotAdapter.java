package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.bean.HotBean;
import com.jiyun.day03.R;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class RecHotAdapter extends RecyclerView.Adapter<RecHotAdapter.ViewHolder> {

    private Context context;
    private List<HotBean.RecentEntity> list;

    public RecHotAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<HotBean.RecentEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.dailynews_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotBean.RecentEntity entity = list.get(position);
        Glide.with(context)
                .load(entity.getThumbnail())
                .into(holder.img);
        holder.title.setText(entity.getTitle());
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
