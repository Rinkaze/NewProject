package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.util.GlideUtil;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/12.
 */

public class RecDynamicAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<BanmiInfo.ResultEntity.ActivitiesEntity> list;
    private final int MORE_IMG = 0;
    private final int BIG_IMG = 1;

    public RecDynamicAdapter(Context context, List<BanmiInfo.ResultEntity.ActivitiesEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MORE_IMG){
            return new MoreImgHolder(View.inflate(context, R.layout.item_banmi_info_moreimg,null));
        }else {
            return new BigImgHoler(View.inflate(context, R.layout.item_banmi_info,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final BanmiInfo.ResultEntity.ActivitiesEntity entity = list.get(position);
        if (getItemViewType(position) == BIG_IMG){
            BigImgHoler bigImgHoler = (BigImgHoler) holder;
            bigImgHoler.tvDate.setText(entity.getDate());
            bigImgHoler.tvIntro.setText(entity.getContent());
            bigImgHoler.tvPraiseCount.setText(entity.getLikeCount()+"");
            bigImgHoler.tvReplyCount.setText(entity.getReplyCount()+"");
            if (entity.isIsLiked()){
                GlideUtil.loadResImage(R.mipmap.praise_unselected,R.mipmap.praise_unselected,R.mipmap.praise,bigImgHoler.ivPraise,context);
            }
            if (entity.getImages().size() == 1){
                GlideUtil.loadUrlImage(R.mipmap.zhanweitu_touxiang,R.mipmap.zhanweitu_touxiang,entity.getImages().get(0),bigImgHoler.bigImg,context);
                bigImgHoler.bigImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onImageClickListener != null){
                            onImageClickListener.onClick(entity.getImages().get(0));
                        }
                    }
                });
            }
        }else {
            MoreImgHolder moreImgHolder = (MoreImgHolder) holder;
            moreImgHolder.tvDate.setText(entity.getDate());
            moreImgHolder.tvIntro.setText(entity.getContent());
            moreImgHolder.tvPraiseCount.setText(entity.getLikeCount()+"");
            moreImgHolder.tvReplyCount.setText(entity.getReplyCount()+"");
            if (entity.isIsLiked()){
                GlideUtil.loadResImage(R.mipmap.praise_unselected,R.mipmap.praise_unselected,R.mipmap.praise,moreImgHolder.ivPraise,context);
            }
            moreImgHolder.recView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL,false));
            RecImageAdapter adapter = new RecImageAdapter(context, entity.getImages());
            moreImgHolder.recView.setAdapter(adapter);
            adapter.setOnImageClickListener(new RecImageAdapter.OnImageClickListener() {
                @Override
                public void onClick(String imgUrl) {
                    if (onImageClickListener != null){
                        onImageClickListener.onClick(imgUrl);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getImages().size()>1){
            return MORE_IMG;
        }else{
            return BIG_IMG;
        }
    }

    class BigImgHoler extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvIntro;
        ImageView bigImg;
        TextView tvReplyCount;
        TextView tvPraiseCount;
        ImageView ivPraise;
        public BigImgHoler(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvIntro = itemView.findViewById(R.id.tv_intro);
            tvReplyCount = itemView.findViewById(R.id.tv_reply_count);
            tvPraiseCount = itemView.findViewById(R.id.tv_praise_count);
            bigImg = itemView.findViewById(R.id.iv_big);
            ivPraise = itemView.findViewById(R.id.iv_praise);

        }
    }

    class MoreImgHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvIntro;
        RecyclerView recView;
        TextView tvReplyCount;
        TextView tvPraiseCount;
        ImageView ivPraise;
        public MoreImgHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvIntro = itemView.findViewById(R.id.tv_intro);
            tvReplyCount = itemView.findViewById(R.id.tv_reply_count);
            tvPraiseCount = itemView.findViewById(R.id.tv_praise_count);
            recView = itemView.findViewById(R.id.recView);
            ivPraise = itemView.findViewById(R.id.iv_praise);
        }
    }

    private OnImageClickListener onImageClickListener;

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public interface OnImageClickListener{
        void onClick(String imgUrl);
    }
}
