package com.solvd.QA.homework_09_02.pages;

import com.solvd.QA.homework_09_02.domain.ItemType;
import com.solvd.QA.homework_09_02.pages.components.AccountWindow;
import com.solvd.QA.homework_09_02.pages.components.CookiesWindow;
import com.solvd.QA.homework_09_02.pages.components.LoginWindow;
import com.solvd.QA.homework_09_02.pages.components.PromoItems;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Optional;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='Search_searchInputContainer__rDgxi']//button")
    private ExtendedWebElement buttonStartSearchByInputSearchRow;

    @FindBy(xpath = "//input[@class='Search_searchInput__RoV1W']")
    private ExtendedWebElement inputSearchRow;

    @FindBy(xpath = "//header[@id='header']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//button[@class='styles_userToolsToggler__c2aHe']")
    private ExtendedWebElement accountDisplayButton;

    @FindBy(xpath = "//*")
    private AccountWindow accountWindow;

    @FindBy(xpath = "//*")
    private LoginWindow loginWindow;

    @FindBy(xpath = "//*")
    private CookiesWindow cookiesWindow;

    @FindBy(xpath = "//*")
    private PromoItems promoItem;

    @FindBy(xpath = "//ul [@class='styles_list__PQC5Y']")
    private ExtendedWebElement bottomElement;

    @FindBy(xpath = "//span [@class='style_upButtonLabel__LPAA4']")
    private ExtendedWebElement upButton;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(header);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public CategoryPage goToCategoryPageBy(ItemType itemType) {
        return promoItem.getPageBy(itemType);
    }

    public SearchPage getSearchPageBy(String keyWord) {
        inputSearchRow.type(keyWord);
        Assert.assertTrue(buttonStartSearchByInputSearchRow.isPresent());
        buttonStartSearchByInputSearchRow.click();
        return new SearchPage(driver);
    }

    public LoginWindow getLoginWindow() {
        accountDisplayButton.click();
        accountWindow.getEnterButton().click();
        return loginWindow;
    }

    public AccountWindow getAccountWindow() {
        return accountWindow;
    }

    public MainPage logout() {
        if (accountWindow.getLogoutButton().isPresent()) {
            accountWindow.getLogoutButton().click();
            return this;
        }
        return this;
    }

    public MainPage acceptCookies() {
        cookiesWindow.getAcceptCookiesButton().click();
        return this;
    }

    public CookiesWindow getCookiesWindow() {
        return cookiesWindow;
    }

    public ExtendedWebElement getAccountDisplayButton() {
        return accountDisplayButton;
    }

    public Optional<ExtendedWebElement> getErrorMassage() {
        if (loginWindow.getEmailErrorMessage().isPresent()) {
            return Optional.of(loginWindow.getEmailErrorMessage());
        } else if (loginWindow.getPassErrorMessage().isPresent()) {
            return Optional.of(loginWindow.getPassErrorMessage());
        } else {
            return Optional.empty();
        }
    }

    public boolean isVisibleUpButton(){
        return upButton.isVisible();
    }

    public ExtendedWebElement getBottomElement() {
        return bottomElement;
    }
}
