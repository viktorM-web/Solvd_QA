package com.solvd.QA.lecture05_02.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = ".//h2//*[text()]")
    private ExtendedWebElement nameProduct;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getNameProduct() {
        return nameProduct;
    }

    public String getTitleText(){
        return nameProduct.getText();
    }
}
