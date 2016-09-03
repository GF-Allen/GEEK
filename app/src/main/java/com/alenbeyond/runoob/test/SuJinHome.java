package com.alenbeyond.runoob.test;

/**
 * Created by AlenBeyond on 2016/9/3.
 */
public class SuJinHome {
    private String title; // 标题
    private String date; // 时间
    private String des; // 描述
    private int letter; // 字数
    private int view; //查看的人数
    private int like; //喜欢的人数
    private String image; //图片链接
    private String url; //文章地址

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SuJinHome{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", des='" + des + '\'' +
                ", letter=" + letter +
                ", view=" + view +
                ", like=" + like +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
