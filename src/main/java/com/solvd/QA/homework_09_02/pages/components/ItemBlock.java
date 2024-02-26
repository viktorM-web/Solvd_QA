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
import java.util.NoSuchElementException;

public class ItemBlock extends AbstractUIObject {

    @FindBy(xpath = ".//li [contains(@class, 'result__item cr-result__simple')]")
    private List<ExtendedWebElement> resultItem;

    public ItemBlock(WebDriver driver) {
        super(driver);
    }

    public List<Item> getItems() {
        List<Item> result = new LinkedList<>();
        for (ExtendedWebElement element : resultItem) {
            String nameItem = null;
            String price = null;
            try{
                nameItem = element.findElement(By.xpath(".//span[@class='result__name']")).getText();
                price = element.findElement(By.xpath(".//span [contains(@class, 'g-item-data j-item-data')]")).getText();

            }catch (NoSuchElementException e){
                if(price==null){
                    price="00.00";
                }else{
                    continue;
                }
            }
            Item item = new Item(nameItem, price);
            result.add(item);
        }
        return result;
    }

    public ItemBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getResultItem() {
        return resultItem;
    }
}
