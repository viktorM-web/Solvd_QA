package com.solvd.QA.homework_09_02.pages.components;

import com.solvd.QA.homework_09_02.domain.UserDto;
import com.solvd.QA.homework_09_02.domain.UserType;
import com.solvd.QA.homework_09_02.pages.MainPage;
import com.solvd.QA.homework_09_02.util.UserService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends AbstractUIObject {

    @FindBy(xpath = ".//input[@id='login-email']")
    private ExtendedWebElement inputNameOrEmail;

    @FindBy(xpath = ".//span[@class='ErrorMessage-module__message']")
    private ExtendedWebElement emailErrorMessage;

    @FindBy(xpath = ".//input[@id='login-password']")
    private ExtendedWebElement inputPass;

    @FindBy(xpath = ".//span[@class='styles_errorText__LEN7M']")
    private ExtendedWebElement passErrorMessage;

    @FindBy(xpath = ".//button [@data-testid='loginSubmit']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = ".//button[@class='Button-module__button Button-module__blue-inline']")
    private ExtendedWebElement registrationLink;

    public LoginWindow(WebDriver driver) {
        super(driver);
    }

    public LoginWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MainPage login(UserType user) {
        UserDto userDto = UserService.getUser(user);
        inputNameOrEmail.type(userDto.getUsername());
        inputPass.type(userDto.getPassword());
        loginButton.click();
        return new MainPage(driver);
    }


    public ExtendedWebElement getInputNameOrEmail() {
        return inputNameOrEmail;
    }

    public void setInputNameOrEmail(ExtendedWebElement inputNameOrEmail) {
        this.inputNameOrEmail = inputNameOrEmail;
    }

    public ExtendedWebElement getInputPass() {
        return inputPass;
    }

    public void setInputPass(ExtendedWebElement inputPass) {
        this.inputPass = inputPass;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(ExtendedWebElement loginButton) {
        this.loginButton = loginButton;
    }

    public ExtendedWebElement getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(ExtendedWebElement registrationLink) {
        this.registrationLink = registrationLink;
    }

    public ExtendedWebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public ExtendedWebElement getPassErrorMessage() {
        return passErrorMessage;
    }
}
