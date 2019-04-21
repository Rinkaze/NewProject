package com.jiyun.bean;

/**
 * Created by 灵风 on 2019/4/19.
 */

public class VtexDataBean {
    private String img_src;
    private String comment_link;
    private String comment_count;
    private String title;
    private String secTab;
    private String author;
    private String fromUser;

    public VtexDataBean() {
    }

    public VtexDataBean(String img_src, String comment_link, String comment_count, String title, String secTab, String author, String fromUser) {
        this.img_src = img_src;
        this.comment_link = comment_link;
        this.comment_count = comment_count;
        this.title = title;
        this.secTab = secTab;
        this.author = author;
        this.fromUser = fromUser;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getComment_link() {
        return comment_link;
    }

    public void setComment_link(String comment_link) {
        this.comment_link = comment_link;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecTab() {
        return secTab;
    }

    public void setSecTab(String secTab) {
        this.secTab = secTab;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        return "VtexDataBean{" +
                "img_src='" + img_src + '\'' +
                ", comment_link='" + comment_link + '\'' +
                ", comment_count='" + comment_count + '\'' +
                ", title='" + title + '\'' +
                ", secTab='" + secTab + '\'' +
                ", author='" + author + '\'' +
                ", fromUser='" + fromUser + '\'' +
                '}';
    }
}
