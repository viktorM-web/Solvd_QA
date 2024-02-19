package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.pages.common.NavigationBarBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.OtherPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    private NavigationBarBase navigationBar;

    public SearchPage(WebDriver driver) {
        super(driver);
        navigationBar=initPage(driver, NavigationBarBase.class);
    }

    @Override
    public SearchPageBase closeUnnecessaryWindows() {
        navigationBar.closeUnnecessaryWindows();
        return this;
    }

    @Override
    public OtherPageBase goToOtherPage(){
        return navigationBar.goToOtherPage();
    }

    @Override
    public boolean otherButtonPresent(){
        return navigationBar.otherButtonPresent();
    }

    @Override
    public List<ExtendedWebElement> getButtonNavigationBar() {
        return navigationBar.getButtonNavigationBar();
    }

}
