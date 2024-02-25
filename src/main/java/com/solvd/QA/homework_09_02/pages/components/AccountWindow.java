package com.solvd.QA.homework_09_02.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountWindow extends AbstractUIObject {

    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private ExtendedWebElement enterButton;

    @FindBy(xpath = "//*[@href='/logout/']")
    private ExtendedWebElement logoutButton;

    public AccountWindow(WebDriver driver) {
        super(driver);
    }

    public AccountWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(ExtendedWebElement enterButton) {
        this.enterButton = enterButton;
    }

    public ExtendedWebElement getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(ExtendedWebElement logoutButton) {
        this.logoutButton = logoutButton;
    }
}
