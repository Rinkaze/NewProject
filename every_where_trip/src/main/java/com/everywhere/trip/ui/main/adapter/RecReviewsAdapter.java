package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/9.
 */

public class RecReviewsAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<MainDataInfo.ResultEntity.ReviewsEntity> list;

    public RecReviewsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<MainDataInfo.ResultEntity.ReviewsEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReviewsHolder(View.inflate(context, R.layout.item_review_all, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReviewsHolder reviewsHolder = (ReviewsHolder) holder;
        if (position == getItemCount()-1){
            reviewsHolder.divider.setVisibility(View.GONE);
        }else {
            reviewsHolder.divider.setVisibility(View.VISIBLE);
        }
        reviewsHolder.tvName.setText(list.get(position).getUserName());
        reviewsHolder.tvDate.setText(list.get(position).getCreatedAt());
        reviewsHolder.tvContent.setText(list.get(position).getContent());
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang,
                list.get(position).getUserPhoto(), reviewsHolder.ivHeader, context);
        if (list.get(position).getImages() != null && list.get(position).getImages().size() > 0) {
            reviewsHolder.recImgs.setLayoutManager(new GridLayoutManager(context,3));
            RecImageAdapter adapter = new RecImageAdapter(context, list.get(position).getImages());
            reviewsHolder.recImgs.setAdapter(adapter);
            adapter.setOnImageClickListener(new RecImageAdapter.OnImageClickListener() {
                @Override
                public void onClick(String imgUrl) {
                    if (onImageClickListener != null) {
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

    class ReviewsHolder extends RecyclerView.ViewHolder {
        ImageView ivHeader;
        TextView tvName;
        TextView tvDate;
        TextView tvContent;
        RecyclerView recImgs;
        View divider;

        public ReviewsHolder(View itemView) {
            super(itemView);
            ivHeader = itemView.findViewById(R.id.iv_header);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvContent = itemView.findViewById(R.id.tv_content);
            recImgs = itemView.findViewById(R.id.rec_imgs);
            divider = itemView.findViewById(R.id.divider);
        }
    }

    private OnImageClickListener onImageClickListener;

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public interface OnImageClickListener {
        void onClick(String imgUrl);
    }

}
