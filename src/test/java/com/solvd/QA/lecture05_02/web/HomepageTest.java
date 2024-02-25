package com.solvd.QA.lecture05_02.web;

import com.solvd.QA.lecture05_02.web.components.ProductCard;
import com.solvd.QA.lecture05_02.web.components.SearchLineComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomepageTest extends AbstractTest {

    @Test
    public void verifySearchLine() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getDriver();
        Homepage homepage = new Homepage(driver);
        homepage.open();

        System.out.println();

        SearchLineComponent searchLineComponent = homepage.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1), "Button select is not present");
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1), "Search input select is not present");
        softAssert.assertEquals(searchLineComponent.getSearchInputPlaceholder(), "Search Amazon", "Search input has an incorrect placeholder");
        softAssert.assertTrue(searchLineComponent.getProductTypesSelect().isElementPresent(1), "Product type select is not present");


        searchLineComponent.typeSearchInputValue("IPhone");
        SearchPage searchPage = searchLineComponent.clickSearchButton();

        softAssert.assertTrue(driver.getCurrentUrl().contains("IPhone"), "Url doesn't contain brand name");
        List<ProductCard> productCards = searchPage.getProductCards();

        for (ProductCard card : productCards) {
            softAssert.assertTrue(card.getTitleText().toLowerCase().contains("1")||card.getTitleText().toLowerCase().contains("1"), String.format("Product with name '%s' doesn't contain the brand in its name", card.getTitleText()));
        }

//        softAssert.assertAll();
    }
}
