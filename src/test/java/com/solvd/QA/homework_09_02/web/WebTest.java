package com.solvd.QA.homework_09_02.web;

import com.solvd.QA.homework_09_02.domain.User;
import com.solvd.QA.homework_09_02.pages.MainPage;
import com.solvd.QA.homework_09_02.pages.components.LoginWindow;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class WebTest extends AbstractTest {

    @Test
    public void verifyValidLoginAndLogoutTest() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        Assert.assertTrue(mainPage.getCookiesWindow().getAcceptCookiesButton().isPresent());
        mainPage.acceptCookies();

        LoginWindow loginWindow = mainPage.getLoginWindow();

        Assert.assertTrue(loginWindow.getLoginButton().isPresent());
        Assert.assertTrue(loginWindow.getInputNameOrEmail().isPresent());
        Assert.assertTrue(loginWindow.getInputPass().isPresent());

        mainPage = loginWindow.login(User.VALID);

        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.getAccountDisplayButton().click();

        Assert.assertTrue(mainPage.getAccountWindow().getLogoutButton().isPresent());

        mainPage = mainPage.logout();

        sa.assertTrue(mainPage.isPageOpened());
        mainPage.getAccountDisplayButton().click();
        sa.assertTrue(mainPage.getAccountWindow().getEnterButton().isPresent());
        sa.assertFalse(mainPage.getAccountWindow().getLogoutButton().isPresent());

        sa.assertAll();
    }

    @Test
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        Assert.assertTrue(mainPage.getCookiesWindow().getAcceptCookiesButton().isPresent());
        mainPage.acceptCookies();

        LoginWindow loginWindow = mainPage.getLoginWindow();

        Assert.assertTrue(loginWindow.getLoginButton().isPresent());
        Assert.assertTrue(loginWindow.getInputNameOrEmail().isPresent());
        Assert.assertTrue(loginWindow.getInputPass().isPresent());

        mainPage = loginWindow.login(User.INVALID_PASS);
        Optional<ExtendedWebElement> errorMassage = mainPage.getErrorMassage();
        sa.assertTrue(errorMassage.isPresent(), "Must appear error message");

        mainPage = loginWindow.login(User.INVALID_EMAIL);
        errorMassage = mainPage.getErrorMassage();
        sa.assertTrue(errorMassage.isPresent(), "Must appear error message");

        sa.assertAll();

    }

    private MainPage getMainPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(40));
        return mainPage;
    }
}


