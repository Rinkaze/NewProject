package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.everywhere.trip.R;
import com.everywhere.trip.util.GlideUtil;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/9.
 */

public class RecImageAdapter extends RecyclerView.Adapter<RecImageAdapter.ViewHolder> {

    private Context context;
    private List<String> imgUrlList;

    public RecImageAdapter(Context context, List<String> imgUrlList) {
        this.context = context;
        this.imgUrlList = imgUrlList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_child_img,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        GlideUtil.loadUrlImage(R.mipmap.zhanweitu_xianlu_jingdian,R.mipmap.zhanweitu_xianlu_jingdian,
                imgUrlList.get(position),holder.img,context);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null){
                    onImageClickListener.onClick(imgUrlList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgUrlList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
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
