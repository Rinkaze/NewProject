package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jiyun.bean.GoldTitleBean;
import com.jiyun.day03.R;
import com.jiyun.widget.TouchCallback;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 灵风 on 2019/4/18.
 */

public class RecShowAdapter extends RecyclerView.Adapter<RecShowAdapter.ViewHolder> implements TouchCallback{

    private Context context;
    private ArrayList<GoldTitleBean> list;

    public RecShowAdapter(Context context, ArrayList<GoldTitleBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_show,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GoldTitleBean titleBean = list.get(position);
        holder.sc.setChecked(titleBean.isChecked);
        holder.tv.setText(titleBean.title);
        holder.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    titleBean.isChecked = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SwitchCompat sc;
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            sc = itemView.findViewById(R.id.sc);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
