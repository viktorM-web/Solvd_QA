package com.solvd.QA.homework_13_02.mobile.gui.pages.common;

import com.solvd.QA.homework_13_02.mobile.gui.models.Account;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ConfirmationPageBase registration(Account account);

    public abstract OtherPageBase login(Account account);

    public abstract boolean errorMessageViewPresent();
}
