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

    @FindBy(xpath = ".//li[@class='result__item cr-result__simple cr-result__first  g-box_lseparator']")
    private List<ExtendedWebElement> resultItem;

    public ItemBlock(WebDriver driver) {
        super(driver);
    }

    public List<Item> getItems() {
        List<Item> result = new LinkedList<>();
        for (ExtendedWebElement element : resultItem) {
            String nameItem = element.findElement(By.xpath("//span[@class='result__name']")).getText();
            String price = element.findElement(By.xpath("//span[@data-code='7116374']")).getText();

            Item item = new Item(nameItem, price);
            result.add(item);
        }
        return result;
    }

    public ItemBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
