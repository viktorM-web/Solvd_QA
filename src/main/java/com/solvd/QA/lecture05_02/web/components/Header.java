package com.solvd.QA.lecture05_02.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id='nav-search']")
    private SearchLineComponent searchLineComponent;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }

    public void setSearchLineComponent(SearchLineComponent searchLineComponent) {
        this.searchLineComponent = searchLineComponent;
    }
}
