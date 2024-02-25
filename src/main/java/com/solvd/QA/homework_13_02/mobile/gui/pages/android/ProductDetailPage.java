package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.models.ProductDto;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ProductDetailPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(xpath = "//android.view.View[@resource-id='by.av.client:id/overlay']")
    private ExtendedWebElement closeRecommendationButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    private ExtendedWebElement notAllowNotificationButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='by.av.client:id/name']")
    private ExtendedWebElement nameProduct;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='by.av.client:id/priceByn']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"by.av.client:id/list\"]/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.TextView")
    private ExtendedWebElement description;

    @FindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='by.av.client:id/bookmark']]")
    private ExtendedWebElement bookmark;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Перейти вверх']")
    private ExtendedWebElement backButton;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductDto getProductDto() {
        return new ProductDto(
                nameProduct.getText(),
                Double.valueOf(price.getText().replaceAll("[^\\d]", "")),
                description.getText());
    }

    @Override
    public ProductListPageBase back() {
        backButton.click();
        return initPage(driver, ProductListPageBase.class);
    }

    @Override
    public ProductDetailPage closeUnnecessaryWindows() {
        while (notAllowNotificationButton.clickIfPresent() || closeRecommendationButton.clickIfPresent()) {
        }
        return this;
    }
}
