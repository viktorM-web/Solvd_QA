package com.solvd.QA.homework_09_02.pages.components;

import com.solvd.QA.homework_09_02.domain.Item;
import com.solvd.QA.homework_09_02.pages.ItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class ItemCard extends AbstractUIObject {

    @FindBy(xpath = ".//a[@data-testid='card-info-a'] | //span[@class='result__name']")
    private ExtendedWebElement nameItem;

    @FindBy(xpath = ".//p [@data-testid='card-current-price'] | //span [contains(@class, 'g-item-data j-item-data')]")
    private ExtendedWebElement priceItem;

    @FindBy(xpath = ".//a[@data-ga_action='GoToItem']")
    private ExtendedWebElement referenceToItemPage;

    public ItemCard(WebDriver driver) {
        super(driver);
    }

    public ItemCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Item getItem() {
        String name = null;
        String price = null;
        try {
            nameItem.isPresent();
            name = nameItem.getText();

            price = priceItem.getText().replace("р.", "");

        } catch (NullPointerException | NoSuchElementException e) {
            if (price == null) {
                price = "00.00";
            }
            if (name==null){
                name="";
            }
        }
        return new Item(name, price);
    }

    public ItemPage goToItemPage(){
        referenceToItemPage.clickIfPresent();
        return new ItemPage(driver);
    }
}
