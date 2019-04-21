package com.jiyun.bean;

/**
 * Created by 灵风 on 2019/4/19.
 */

public class VtexTitleBean {
    private String link;
    private String title;

    public VtexTitleBean() {
    }

    public VtexTitleBean(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "VtexTitleBean{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
