package com.solvd.QA.lecture05_02.web.components;

import com.solvd.QA.lecture05_02.web.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'nav-search-dropdown')]")
//    @FindBy(id = "searchDropdownBox") same
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath = ".//input[@id='twotabsearchtextbox']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//input[@id='nav-search-submit-button']")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputValue(String value) {
//        searchInput.sendKeys(value);
        searchInput.type(value);
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("aria-label");
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
    }

    public void setProductTypesSelect(ExtendedWebElement productTypesSelect) {
        this.productTypesSelect = productTypesSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(ExtendedWebElement searchInput) {
        this.searchInput = searchInput;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(ExtendedWebElement searchButton) {
        this.searchButton = searchButton;
    }
}
