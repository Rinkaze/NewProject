package com.jiyun.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.jiyun.bean.VtexTitleBean;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/19.
 */

public class VpChildVtexAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<VtexTitleBean> titles;

    public VpChildVtexAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<VtexTitleBean> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
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
        return titles.get(position).getTitle();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
