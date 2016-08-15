package com.alenbeyond.runoob.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 获取章节
 * Created by AlenBeyond on 2016/5/23.
 */
@Entity
public class RunoobChapter {

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

    public RunoobChapter(String title, String link) {
        super();
        this.title = title;
        this.link = link;
    }

    @Generated(hash = 1043888901)
    public RunoobChapter(Long id, String title, String link, Long itemId) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.itemId = itemId;
    }

    @Generated(hash = 858249302)
    public RunoobChapter() {
    }

    @Override
    public String toString() {
        return "RunoobChapter [title=" + title + ", link=" + link + "]";
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
