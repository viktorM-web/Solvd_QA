package com.solvd.QA.homework_13_02;

import com.solvd.QA.homework_13_02.mobile.gui.models.Account;
import com.solvd.QA.homework_13_02.mobile.gui.pages.android.SearchPage;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ConfirmationPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.LoginPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.OtherPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AndroidTest extends AbstractTest {

    @Test
    public void verifyRegistration() {
        SoftAssert softAssert = new SoftAssert();
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.closeUnnecessaryWindows();
        softAssert.assertTrue(searchPage.otherButtonPresent(), "Button not found");

        OtherPageBase otherPageBase = searchPage.goToOtherPage();

        LoginPageBase loginPageBase = otherPageBase.goToLogin();

        Account account = new Account();
        account.setName("Тест");
        account.setPhone("+37529 111 11 11");
        account.setPass("pass11111111!");

        ConfirmationPageBase confirmationPageBase = loginPageBase.registration(account);
        softAssert.assertTrue(confirmationPageBase.containsAllFields());
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginWithValidUser() {
        SoftAssert softAssert = new SoftAssert();
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.closeUnnecessaryWindows();
        softAssert.assertTrue(searchPage.otherButtonPresent(), "Button not found");

        OtherPageBase otherPageBase = searchPage.goToOtherPage();

        LoginPageBase loginPageBase = otherPageBase.goToLogin();

        Account account = new Account();
        account.setPhone(R.TESTDATA.get("valid.login.android.app"));
        account.setPass(R.TESTDATA.get("valid.pass.android.app"));

        otherPageBase = loginPageBase.login(account);
        softAssert.assertTrue(otherPageBase.isPageOpened());
        softAssert.assertFalse(otherPageBase.registrationButtonPresent());
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginWithInvalidUser() {
        SoftAssert softAssert = new SoftAssert();
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.closeUnnecessaryWindows();
        softAssert.assertTrue(searchPage.otherButtonPresent(), "Button not found");

        OtherPageBase otherPageBase = searchPage.goToOtherPage();

        LoginPageBase loginPageBase = otherPageBase.goToLogin();

        Account account = new Account();
        account.setPhone(R.TESTDATA.get("valid.login.android.app"));
        account.setPass("pqfe16691!?");

        otherPageBase = loginPageBase.login(account);
        softAssert.assertFalse(otherPageBase.isPageOpened());
        softAssert.assertTrue(loginPageBase.errorMessageViewPresent());
        softAssert.assertAll();
    }

    @Test
    public void verifyLocationAndSizeButton() {
        SoftAssert softAssert = new SoftAssert();
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.closeUnnecessaryWindows();
        List<ExtendedWebElement> buttons = searchPage.getButtonNavigationBar();

        for (int i=0;i<buttons.size()-1;i++) {

            softAssert.assertFalse(buttons.get(i).getLocation().getX()==buttons.get(i+1).getLocation().getX(),
                    "The buttons must have different X coordinates");

            softAssert.assertTrue(buttons.get(i).getLocation().getY()==buttons.get(i+1).getLocation().getY(),
                    "The buttons are not aligned on the Y axis");

            softAssert.assertTrue(buttons.get(i).getSize().equals(buttons.get(i+1).getSize()),
                    "The buttons different size");
        }
        softAssert.assertAll();
    }
}
