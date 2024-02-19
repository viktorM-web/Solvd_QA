package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.models.Account;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ConfirmationPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.LoginPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.OtherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Регистрация\"]")
    private ExtendedWebElement registrationButton;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Вход\"]")
    private ExtendedWebElement enterButton;
    @FindBy(id = "by.av.client:id/nameEditView")
    private ExtendedWebElement inputName;
    @FindBy(id = "by.av.client:id/phoneEditView")
    private ExtendedWebElement inputPhone;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='by.av.client:id/emailEditView']")
    private ExtendedWebElement inputEmail;
    @FindBy(id = "by.av.client:id/passwordEditView")
    private ExtendedWebElement inputPass;
    @FindBy(id = "by.av.client:id/checkBox")
    private ExtendedWebElement checkBox;
    @FindBy(id = "by.av.client:id/signUpButton")
    private ExtendedWebElement confirmButton;
    @FindBy(id = "by.av.client:id/loginButton")
    private ExtendedWebElement loginButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='by.av.client:id/chipEmailText']")
    private ExtendedWebElement emailButton;
    @FindBy(id = "by.av.client:id/errorMessageView")
    private ExtendedWebElement errorMessageView;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ConfirmationPageBase registration(Account account) {

        registrationButton.click();

        if (account.getPhone() == null && account.getEmail() == null) {
            throw new RuntimeException();
        } else if (account.getPhone() == null) {
            emailButton.click();
            inputEmail.type(account.getEmail());
        } else {
            inputPhone.type(account.getPhone());
        }
        inputName.type(account.getName());
        inputPass.type(account.getPass());
        checkBox.click();

        Assert.assertTrue(confirmButton.isPresent());
        confirmButton.click();
        return initPage(driver, ConfirmationPageBase.class);
    }

    @Override
    public OtherPageBase login(Account account) {
        enterButton.click();
        if (account.getPhone() == null && account.getEmail() == null) {
            throw new RuntimeException();
        } else if (account.getPhone() == null) {
            emailButton.click();
            inputEmail.type(account.getEmail());
        } else {
            inputPhone.type(account.getPhone());
        }
        inputPass.type(account.getPass());
        loginButton.click();

        return initPage(driver, OtherPageBase.class);
    }

    @Override
    public boolean errorMessageViewPresent(){
        return errorMessageView.isPresent();
    }

}
