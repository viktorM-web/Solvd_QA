package com.solvd.QA.homework_09_02.pages;

public enum Sort {

    CHEAP("Дешевые"),
    EXPENSIVE("Дорогие");

    String name;

    Sort(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
