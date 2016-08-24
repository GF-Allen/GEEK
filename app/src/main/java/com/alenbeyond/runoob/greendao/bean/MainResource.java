package com.alenbeyond.runoob.greendao.bean;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class MainResource {

    private int drawableID;
    private String title;
    private String url;

    public MainResource() {
    }

    public MainResource(int drawableID, String title, String url) {
        this.drawableID = drawableID;
        this.title = title;
        this.url = url;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(int drawableID) {
        this.drawableID = drawableID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MainResource{" +
                "drawableID=" + drawableID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
