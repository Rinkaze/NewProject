package com.jiyun.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jiyun.bean.GoldTitleBean;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/18.
 */

public class VpGoldAdapter extends FragmentStatePagerAdapter {

    private ArrayList<GoldTitleBean> titles;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> mNewTitles = new ArrayList<>();

    public VpGoldAdapter(FragmentManager fm,ArrayList<GoldTitleBean> titles,ArrayList<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
        for (GoldTitleBean title : titles) {
            if (title.isChecked){
                mNewTitles.add(title.title);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNewTitles.get(position);
    }
}
