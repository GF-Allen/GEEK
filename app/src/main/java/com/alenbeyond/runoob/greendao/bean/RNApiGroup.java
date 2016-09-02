package com.alenbeyond.runoob.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Alen on 2016/9/2.
 */
@Entity
public class RNApiGroup {

    @Id
    private Long id;
    private int reactId;
    private String name;

    public RNApiGroup() {
    }

    public RNApiGroup(int reactId, String name) {
        this.reactId = reactId;
        this.name = name;
    }

    @Generated(hash = 1186492384)
    public RNApiGroup(Long id, int reactId, String name) {
        this.id = id;
        this.reactId = reactId;
        this.name = name;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
