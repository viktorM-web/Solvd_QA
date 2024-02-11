package com.solvd.QA.homework_09_02.pages.components;

import com.solvd.QA.homework_09_02.domain.ItemType;
import com.solvd.QA.homework_09_02.pages.CategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PromoItems extends AbstractUIObject {

    @FindBy(xpath = "//li[@class='styles_promoItem__aolWq']")
    private List<ExtendedWebElement> promoItemButtons;

    public PromoItems(WebDriver driver) {
        super(driver);
    }

    public PromoItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CategoryPage getPageBy(ItemType itemType) {
        promoItemButtons.get(itemType.getIndex()).click();
        return new CategoryPage(driver);
    }
}
