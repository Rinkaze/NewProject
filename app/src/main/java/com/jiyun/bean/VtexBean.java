package com.jiyun.bean;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/19.
 */

public class VtexBean {
    private ArrayList<VtexTitleBean> titles;
    private ArrayList<VtexDataBean> datas;

    public VtexBean(ArrayList<VtexTitleBean> titles, ArrayList<VtexDataBean> datas) {
        this.titles = titles;
        this.datas = datas;
    }

    public VtexBean() {
    }

    public ArrayList<VtexTitleBean> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<VtexTitleBean> titles) {
        this.titles = titles;
    }

    public ArrayList<VtexDataBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<VtexDataBean> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "VtexBean{" +
                "titles=" + titles +
                ", datas=" + datas +
                '}';
    }
}
