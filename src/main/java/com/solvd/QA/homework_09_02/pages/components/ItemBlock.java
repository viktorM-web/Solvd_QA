package com.solvd.QA.homework_09_02.pages.components;

import com.solvd.QA.homework_09_02.domain.Item;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class ItemBlock extends AbstractUIObject {

    @FindBy(xpath = ".//li [contains(@class, 'result__item cr-result__simple')]")
    private List<ItemCard> itemCards;

    public ItemBlock(WebDriver driver) {
        super(driver);
    }

    public List<Item> getItems() {
        List<Item> result = new LinkedList<>();
        for (ItemCard itemCard : itemCards) {
            result.add(itemCard.getItem());
        }
        return result;
    }

    public ItemBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ItemCard> getItemCards() {
        return itemCards;
    }
}
