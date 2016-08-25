package com.alenbeyond.runoob.greendao.bean;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class MainResource {

    private int drawableID;
    private String title;
    private String url;
    private String type;

    public MainResource() {
    }

    public MainResource(int drawableID, String title, String url, String type) {
        this.drawableID = drawableID;
        this.title = title;
        this.url = url;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MainResource{" +
                "drawableID=" + drawableID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
