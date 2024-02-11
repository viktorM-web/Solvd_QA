package com.solvd.QA.homework_09_02.domain;

public enum ItemType {

    TIRES(1, "шина"),
    REFRIGERATORS(2, "холодильник"),
    MOBILE(3, "смартфон"),
    NOTEBOOKS(4, "ноутбук");

    Integer index;
    String name;

    ItemType(Integer index, String name) {
        this.index=index;
        this.name=name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
