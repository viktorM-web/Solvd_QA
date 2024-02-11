package com.solvd.QA.homework_09_02.util;

import com.solvd.QA.homework_09_02.domain.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class SortUtil {

    private SortUtil(){
    }

    public static List<Item> sortStartFromCheap(List<Item> items){
        return items.stream()
                .sorted(Comparator.comparingDouble(Item::getPrice))
                .collect(Collectors.toList());
    }

    public static List<Item> sortStartFromExpensive(List<Item> items){
        return items.stream()
                .sorted((item1,item2)->Double.compare(item1.getPrice(), item2.getPrice())*(-1))
                .collect(Collectors.toList());
    }
}
