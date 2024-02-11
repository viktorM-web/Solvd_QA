package com.solvd.QA.homework_09_02.web;

import com.solvd.QA.homework_09_02.domain.Item;
import com.solvd.QA.homework_09_02.domain.ItemType;
import com.solvd.QA.homework_09_02.domain.User;
import com.solvd.QA.homework_09_02.pages.*;
import com.solvd.QA.homework_09_02.pages.components.LoginWindow;
import com.solvd.QA.homework_09_02.util.SortUtil;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;

public class WebTest extends AbstractTest {

    @Test
    public void verifyValidLoginAndLogoutTest() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

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

    @Test(description = "Verify search")
    public void verifySearchingLineTest() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        SearchPage searchPage = mainPage.getSearchPageBy("apple");

        Assert.assertTrue(searchPage.isPageOpened());

        List<Item> allItemFromPage = searchPage.getAllItemFromPage();

        allItemFromPage.forEach(item -> {
            Assert.assertTrue(item.getName().toLowerCase().contains("apple"));
        });
    }

    @Test
    public void verifyCartItems() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        SearchPage searchPage = mainPage.getSearchPageBy("apple");
        Assert.assertTrue(searchPage.isPageOpened());
        Item itemFromPageBy = searchPage.getItemFromPageBy(9);
        ItemPage itemPage = searchPage.goToItemPage(9);
        Assert.assertTrue(itemPage.isPageOpened());
        Item itemFromItemPage = itemPage.getItem();

        Assert.assertEquals(itemFromItemPage, itemFromPageBy,
                "Item's data from item's page and search page not equals");
    }

    @Test
    public void verifyOpeningSearchPageAndSwitchByItemsCategory() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        Assert.assertTrue(mainPage.isPageOpened());

        CategoryPage categoryPage = mainPage.goToCategoryPageBy(ItemType.REFRIGERATORS);
        Assert.assertTrue(categoryPage.isPageOpened());
        List<Item> items = categoryPage.getItems();
        items.forEach(item -> {
            Assert.assertTrue(item.getName().toLowerCase().contains(ItemType.REFRIGERATORS.getName()));
        });

        Assert.assertFalse(categoryPage.isVisibleUpButton());
        categoryPage.getBottomElement().scrollTo();
        Assert.assertTrue(categoryPage.isVisibleUpButton());

        categoryPage = categoryPage.switchPageTo(ItemType.MOBILE);
        Assert.assertTrue(categoryPage.isPageOpened());
        items = categoryPage.getItems();
        items.forEach(item -> {
            Assert.assertTrue(item.getName().toLowerCase().contains(ItemType.MOBILE.getName()) ||
                              item.getName().toLowerCase().contains("телефон"));
        });

        Assert.assertFalse(categoryPage.isVisibleUpButton());
        categoryPage.getBottomElement().scrollTo();
        Assert.assertTrue(categoryPage.isVisibleUpButton());

        categoryPage = categoryPage.switchPageTo(ItemType.TIRES);
        Assert.assertTrue(categoryPage.isPageOpened());
        items = categoryPage.getItems();
        items.forEach(item -> {
            Assert.assertTrue(item.getName().toLowerCase().contains(ItemType.TIRES.getName()));
        });

        Assert.assertFalse(categoryPage.isVisibleUpButton());
        categoryPage.getBottomElement().scrollTo();
        Assert.assertTrue(categoryPage.isVisibleUpButton());
    }

    @Test
    public void verifySortItems() {
        SoftAssert sa = new SoftAssert();
        MainPage mainPage = getMainPage();

        Assert.assertTrue(mainPage.isPageOpened());

        CategoryPage categoryPage = mainPage.goToCategoryPageBy(ItemType.REFRIGERATORS);
        Assert.assertTrue(categoryPage.isPageOpened());
        categoryPage = categoryPage.sortItem(Sort.CHEAP);
        List<Item> actual = categoryPage.getItems();
        List<Item> expected = SortUtil.sortStartFromCheap(actual);

        Assert.assertEquals(actual, expected);

        categoryPage = categoryPage.sortItem(Sort.EXPENSIVE);
        actual = categoryPage.getItems();
        expected = SortUtil.sortStartFromExpensive(actual);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyScrollPagesTest() {
        MainPage mainPage = getMainPage();

        Assert.assertFalse(mainPage.isVisibleUpButton());
        mainPage.getBottomElement().scrollTo();
        Assert.assertTrue(mainPage.isVisibleUpButton());
    }


    private MainPage getMainPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened());

        Assert.assertTrue(mainPage.getCookiesWindow().getAcceptCookiesButton().isPresent());
        mainPage.acceptCookies();
        return mainPage;
    }
}


