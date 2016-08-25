package com.alenbeyond.runoob.resource.rxjava.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AllOperators {

    @Id
    private Long id;
    private String name;
    private String thread;
    private String desc;
    private String img;
    private String url;
    private Long operators_id;

    @Generated(hash = 1873520834)
    public AllOperators(Long id, String name, String thread, String desc,
            String img, String url, Long operators_id) {
        this.id = id;
        this.name = name;
        this.thread = thread;
        this.desc = desc;
        this.img = img;
        this.url = url;
        this.operators_id = operators_id;
    }

    @Generated(hash = 1266766031)
    public AllOperators() {
    }

//    private Operators Operators;
//    private Long operators__resolvedKey;

    @Override
    public String toString() {
        return "AllOperators{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thread='" + thread + '\'' +
                ", desc='" + desc + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", operators_id=" + operators_id +
//                ", Operators=" + Operators +
//                ", operators__resolvedKey=" + operators__resolvedKey +
                '}';
    }

    public Long getOperators_id() {
        return this.operators_id;
    }

    public void setOperators_id(Long operators_id) {
        this.operators_id = operators_id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getThread() {
        return this.thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getName() {
        return this.name;
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
