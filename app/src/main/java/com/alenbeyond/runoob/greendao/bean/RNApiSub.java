package com.alenbeyond.runoob.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Alen on 2016/9/2.
 */
@Entity
public class RNApiSub {
    @Id
    private Long id;
    private int reactId;
    private String name;
    private String url;
    private Long groupId;

    public RNApiSub() {
    }

    public RNApiSub(int reactId, String name, String url, Long groupId) {
        this.reactId = reactId;
        this.name = name;
        this.url = url;
        this.groupId = groupId;
    }

    @Generated(hash = 949614367)
    public RNApiSub(Long id, int reactId, String name, String url, Long groupId) {
        this.id = id;
        this.reactId = reactId;
        this.name = name;
        this.url = url;
        this.groupId = groupId;
    }

    public int getReactId() {
        return reactId;
    }

    public void setReactId(int reactId) {
        this.reactId = reactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RNApiSub{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", reactId=" + reactId +
                '}';
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
