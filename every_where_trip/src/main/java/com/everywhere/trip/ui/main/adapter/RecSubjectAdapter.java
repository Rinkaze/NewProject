package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.BundlesBean;
import com.everywhere.trip.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class RecSubjectAdapter extends RecyclerView.Adapter<RecSubjectAdapter.ViewHolder> {

    private Context context;
    private List<BundlesBean.ResultEntity.BundlesEntity> list;

    public RecSubjectAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<BundlesBean.ResultEntity.BundlesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecSubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_bundle,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecSubjectAdapter.ViewHolder holder, int position) {
        final BundlesBean.ResultEntity.BundlesEntity entity = list.get(position);
        GlideUtil.loadUrlImage(R.mipmap.zhanweitu_home_kapian,R.mipmap.zhanweitu_home_kapian,
                entity.getCardURL(),holder.bigImg,context);
        holder.bigImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBundleClickListener != null){
                    onBundleClickListener.onClick(entity.getContentURL(),entity.getTitle());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bigImg;

        public ViewHolder(View itemView) {
            super(itemView);
            bigImg = itemView.findViewById(R.id.bg_img);
        }
    }

    private OnBundleClickListener onBundleClickListener;

    public void setOnBundleClickListener(OnBundleClickListener onBundleClickListener) {
        this.onBundleClickListener = onBundleClickListener;
    }

    public interface OnBundleClickListener{
        void onClick(String url,String title);
    }
}
