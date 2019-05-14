package com.everywhere.trip.widget;

/**
 * @author xts
 *         Created by asus on 2019/4/19.
 */

public interface TouchCallBack {
    //交换条目位置
    void onItemMove(int fromPosition, int toPosition);
    //删除条目
    void onItemDelete(int position);
}
