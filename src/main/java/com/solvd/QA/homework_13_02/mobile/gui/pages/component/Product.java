package com.solvd.QA.homework_13_02.mobile.gui.pages.component;

import com.solvd.QA.homework_13_02.mobile.gui.models.ProductDto;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = ".//android.widget.TextView[@resource-id=\"by.av.client:id/name\"]")
    private ExtendedWebElement nameProduct;

    @FindBy(xpath = ".//android.widget.TextView[@resource-id=\"by.av.client:id/priceByn\"]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//android.widget.TextView[@resource-id=\"by.av.client:id/description\"]")
    private ExtendedWebElement description;

    @FindBy(xpath = ".//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"by.av.client:id/bookmark\"]]")
    private ExtendedWebElement bookmark;

    public Product(WebDriver driver) {
        super(driver);
    }

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductDto getDto() {
        return new ProductDto(
                nameProduct.getText(),
                Double.valueOf(price.getText().replaceAll("[^\\d]", "")),
                description.getText());
    }

    public boolean allElementsPresent() {
        return nameProduct.isElementPresent() && price.isElementPresent() && description.isElementPresent()
                && nameProduct.isDisplayed() && price.isDisplayed() && description.isDisplayed();
    }

    public ExtendedWebElement getNameProduct() {
        return nameProduct;
    }
}
