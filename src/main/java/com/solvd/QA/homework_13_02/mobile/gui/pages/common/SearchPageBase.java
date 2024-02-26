package com.solvd.QA.homework_13_02.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListPageBase goToProductListPage();

    public abstract OtherPageBase goToOtherPage();

    public abstract SearchPageBase closeUnnecessaryWindows();

    public abstract boolean otherButtonPresent();

    public abstract List<ExtendedWebElement> getButtonNavigationBar();
}
