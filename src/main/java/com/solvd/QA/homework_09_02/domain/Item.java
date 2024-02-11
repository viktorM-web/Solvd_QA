package com.solvd.QA.homework_09_02.domain;

import java.util.Objects;

public class Item {

    private String name;
    private Double price;

    public Item(String name, String price) {
        String priceInDoubleFormat = price.replace(" ", "").replace(",", ".");
        this.name = name;
        this.price = Double.valueOf(priceInDoubleFormat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
