package com.alenbeyond.runoob.greendao.bean;

/**
 * Created by Alen on 2016/8/17.
 */
public class AnyCodesPDF {
    private String title;
    private String url;
    private String size;

    public AnyCodesPDF() {
    }

    public AnyCodesPDF(String title, String url, String size) {
        this.title = title;
        this.url = url;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "AnyCodesPDF{" +
                "size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
