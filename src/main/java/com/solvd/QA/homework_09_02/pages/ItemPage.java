package com.solvd.QA.homework_09_02.pages;

import com.solvd.QA.homework_09_02.domain.Item;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(xpath = "//h1[@itemprop='name']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = "//span[@itemprop='price']")
    private ExtendedWebElement itemPrice;

    public ItemPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(itemName);
    }

    public Item getItem(){
        return new Item(itemName.getText(), itemPrice.getText());
    }
}
