package com.alenbeyond.runoob.resource.rxjava.bean;

public class Operators {

    private Long id;
    private String name;
    private Long outer_id;

    private AllOperators AllOperators;
    private Long allOperators__resolvedKey;

    public Operators(Long id, String name, Long outer_id) {
        this.id = id;
        this.name = name;
        this.outer_id = outer_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(Long outer_id) {
        this.outer_id = outer_id;
    }

    public AllOperators getAllOperators() {
        return AllOperators;
    }

    public void setAllOperators(AllOperators allOperators) {
        this.AllOperators = allOperators;
    }

    public Long getAllOperators__resolvedKey() {
        return allOperators__resolvedKey;
    }

    public void setAllOperators__resolvedKey(Long allOperators__resolvedKey) {
        this.allOperators__resolvedKey = allOperators__resolvedKey;
    }

    @Override
    public String toString() {
        return "Operators{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", outer_id=" + outer_id +
                ", AllOperators=" + AllOperators +
                ", allOperators__resolvedKey=" + allOperators__resolvedKey +
                '}';
    }
}
