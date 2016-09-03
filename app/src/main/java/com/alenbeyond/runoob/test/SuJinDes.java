package com.alenbeyond.runoob.test;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/9/3.
 */
public class SuJinDes {

    private String title;
    private String stuff;
    private String content;
    private String music;
    private List<String> images;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "SuJinDes{" +
                "title='" + title + '\'' +
                ", stuff='" + stuff + '\'' +
                ", content='" + content + '\'' +
                ", music='" + music + '\'' +
                ", images=" + images +
                '}';
    }
}
