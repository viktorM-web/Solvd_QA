package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.pages.common.LoginPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.OtherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OtherPageBase.class)
public class OtherPage extends OtherPageBase {

    @FindBy(id = "by.av.client:id/other_toolbar")
    private ExtendedWebElement otherToolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Войти']")
    private ExtendedWebElement registrationButton;

    public OtherPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(otherToolbar);
    }

    @Override
    public LoginPageBase goToLogin() {
        Assert.assertTrue(registrationButton.isPresent());
        registrationButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean registrationButtonPresent() {
        return registrationButton.isPresent();
    }

}
