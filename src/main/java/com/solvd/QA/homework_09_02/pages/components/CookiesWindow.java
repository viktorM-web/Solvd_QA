package com.solvd.QA.homework_09_02.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CookiesWindow extends AbstractUIObject {

    @FindBy(xpath = "//button[@class='Button-module__button Button-module__blue-primary']")
    private ExtendedWebElement acceptCookiesButton;

    public CookiesWindow(WebDriver driver) {
        super(driver);
    }

    public CookiesWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }
}
