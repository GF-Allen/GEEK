package com.alen.runoob.greendao.bean;

/**
 * Created by AlenBeyond on 2016/8/12.
 */
public class GithubCollect {
    private String title;
    private String url;

    public GithubCollect(String title, String url) {
        this.title = title;
        this.url = url;
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
        return "GithubCollect{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
