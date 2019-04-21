package com.jiyun.widget;

/**
 * Created by 灵风 on 2019/4/19.
 */

public interface TouchCallback {
    void onItemMove(int fromPosition,int toPosition);
    void onItemDelete(int position);
}
