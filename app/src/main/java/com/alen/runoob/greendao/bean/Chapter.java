package com.alen.runoob.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 获取章节
 * Created by Jeff on 2016/5/23.
 */
@Entity
public class Chapter {

    @Id
    private Long id;
    private String title;
    private String link;
    private Long itemId;

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

    @Generated(hash = 1223163661)
    public Chapter(Long id, String title, String link, Long itemId) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.itemId = itemId;
    }

    @Generated(hash = 393170288)
    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter [title=" + title + ", link=" + link + "]";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
