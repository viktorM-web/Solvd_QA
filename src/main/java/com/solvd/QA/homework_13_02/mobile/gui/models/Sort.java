package com.solvd.QA.homework_13_02.mobile.gui.models;

public enum Sort {
    CHEAP("дешёвые"),
    EXPENSIVE("дорогие");

    String type;

    Sort(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
