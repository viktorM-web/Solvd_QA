package com.solvd.QA.homework_13_02.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class OtherPageBase extends AbstractPage {

    public OtherPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase goToLogin();

    public abstract boolean registrationButtonPresent();
}
