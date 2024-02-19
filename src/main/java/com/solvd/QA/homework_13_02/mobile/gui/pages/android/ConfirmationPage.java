package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ConfirmationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmationPageBase.class)
public class ConfirmationPage extends ConfirmationPageBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"by.av.client:id/passwordEditView\"]")
    private ExtendedWebElement inputCodeFromSms;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean containsAllFields() {
        return inputCodeFromSms.isPresent();
    }
}
