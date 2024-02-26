package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.pages.common.NavigationBarBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.OtherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NavigationBarBase.class)
public class NavigationBar extends NavigationBarBase {

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Поиск']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Избранное']")
    private ExtendedWebElement favoritesButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Объявления']")
    private ExtendedWebElement postsButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Диалоги']")
    private ExtendedWebElement chatsButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Прочее']")
    private ExtendedWebElement otherButton;

    @FindBy(xpath = "//android.view.View[@resource-id='by.av.client:id/overlay']")
    private ExtendedWebElement closeRecommendationButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    private ExtendedWebElement notAllowNotificationButton;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public NavigationBar closeUnnecessaryWindows() {
        while (notAllowNotificationButton.clickIfPresent() || closeRecommendationButton.clickIfPresent()) {
        }
        return this;
    }

    @Override
    public OtherPageBase goToOtherPage() {
        otherButton.click();
        return initPage(driver, OtherPageBase.class);
    }

    @Override
    public boolean otherButtonPresent() {
        return otherButton.isPresent();
    }

    @Override
    public List<ExtendedWebElement> getButtonNavigationBar() {
        return List.of(
                searchButton,
                favoritesButton,
                postsButton,
                chatsButton,
                otherButton
        );
    }
}
