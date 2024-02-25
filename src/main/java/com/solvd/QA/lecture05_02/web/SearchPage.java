package com.solvd.QA.lecture05_02.web;

import com.solvd.QA.lecture05_02.web.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 's-card-container')]")
    private List<ProductCard> productCards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }
}
