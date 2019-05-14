package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/6.
 */

public class RecBanmiAdapter extends RecyclerView.Adapter<RecBanmiAdapter.ViewHolder> {

    private Context context;
    private List<BanmiBean.ResultEntity.BanmiEntity> list;

    public RecBanmiAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<BanmiBean.ResultEntity.BanmiEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecBanmiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_banmi,null));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecBanmiAdapter.ViewHolder holder, final int position) {
        GlideUtil.loadUrlRoundImg(6,R.mipmap.zhanweitu_home_kapian,R.mipmap.zhanweitu_home_kapian,
                list.get(position).getPhoto(),holder.img,context);
        if (list.get(position).isIsFollowed()){
            GlideUtil.loadResImage(R.mipmap.zhanweitu_home_kapian,R.mipmap.zhanweitu_home_kapian,
                    R.mipmap.follow,holder.ivFollow,context);
        }else {
            GlideUtil.loadResImage(R.mipmap.zhanweitu_home_kapian,R.mipmap.zhanweitu_home_kapian,
                    R.mipmap.follow_unselected,holder.ivFollow,context);
        }
        holder.tvName.setText(list.get(position).getName());
        holder.tvFollowing.setText(list.get(position).getFollowing()+"人关注");
        holder.tvOccupation.setText(list.get(position).getOccupation());
        holder.tvCity.setText(list.get(position).getLocation());
        holder.ivFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isIsFollowed()){
                    if (onFollowCliclListener != null){
                        ToastUtil.showShort("已取消关注");
                        onFollowCliclListener.cancelFollow(list.get(position).getId());
                        Glide.with(context).load(R.mipmap.follow_unselected).into(holder.ivFollow);
                        list.get(position).setIsFollowed(false);
                    }
                }else {
                    if (onFollowCliclListener != null){
                        ToastUtil.showShort("已关注");
                        onFollowCliclListener.onFollow(list.get(position).getId());
                        Glide.with(context).load(R.mipmap.follow).into(holder.ivFollow);
                        list.get(position).setIsFollowed(true);
                    }
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onClick(list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvName;
        TextView tvFollowing;
        TextView tvCity;
        TextView tvOccupation;
        ImageView ivFollow;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tv_name);
            tvFollowing = itemView.findViewById(R.id.tv_following);
            tvCity = itemView.findViewById(R.id.tv_city);
            tvOccupation = itemView.findViewById(R.id.tv_occupation);
            ivFollow = itemView.findViewById(R.id.iv_follow);
        }
    }
    private OnFollowCliclListener onFollowCliclListener;

    public void setOnFollowCliclListener(OnFollowCliclListener onFollowCliclListener) {
        this.onFollowCliclListener = onFollowCliclListener;
    }

    public interface OnFollowCliclListener{
        void onFollow(int id);
        void cancelFollow(int id);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(BanmiBean.ResultEntity.BanmiEntity entity);
    }
}
