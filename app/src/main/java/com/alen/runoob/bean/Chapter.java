package com.alen.runoob.bean;

/**
 * 获取章节
 * Created by Jeff on 2016/5/23.
 */
public class Chapter {

    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Chapter(String title, String link) {
        super();
        this.title = title;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Chapter [title=" + title + ", link=" + link + "]";
    }

}
