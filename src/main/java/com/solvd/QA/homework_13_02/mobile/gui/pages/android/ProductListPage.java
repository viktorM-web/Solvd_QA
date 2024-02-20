package com.solvd.QA.homework_13_02.mobile.gui.pages.android;

import com.solvd.QA.homework_13_02.mobile.gui.models.ProductDto;
import com.solvd.QA.homework_13_02.mobile.gui.models.Sort;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ProductDetailPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.common.ProductListPageBase;
import com.solvd.QA.homework_13_02.mobile.gui.pages.component.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Сортировка\"]")
    private ExtendedWebElement sort;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"by.av.client:id/close\"]")
    private ExtendedWebElement closeSortMenu;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id=\"by.av.client:id/radioButton\"]")
    private List<ExtendedWebElement> radioButtons;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"by.av.client:id/itemListCar\"])[1]")
    private Product product1;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"by.av.client:id/itemListCar\"])[2]")
    private Product product2;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListPageBase sortProductBy(Sort typeSort) {
        sort.click();
        closeSortMenu.isPresent(5);
        radioButtons.stream().filter(element -> element.getText().contains(typeSort.getType()))
                .findFirst().get().click();
        return this;
    }

    @Override
    public ProductListPageBase swapPage() {
        swipeUp(25);
        return this;
    }

    @Override
    public List<ProductDto> getProducts(Integer count) {
        List<ProductDto> products = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (product1.allElementsPresent()) {
                products.add(product1.getDto());
            } else if (product2.allElementsPresent()) {
                products.add(product2.getDto());
            } else {
                i--;
            }
            swipeUp(25);
        }
        return products;
    }

    @Override
    public ProductDto getRandomProduct(Integer count) {
        ProductDto random = null;
        for (int i = 0; random == null; i++) {
            if (i < count) {
                swipeUp(25);
            } else if (product1.allElementsPresent()) {
                random = product1.getDto();
            } else if (product2.allElementsPresent()) {
                random = product2.getDto();
            } else {
                swipeUp(25);
            }
        }
        return random;
    }

    @Override
    public ProductDetailPageBase goToDetailPageFullyShownProduct() {
        if (product1.allElementsPresent()) {
            product1.getNameProduct().click();
        } else {
            product2.getNameProduct().click();
        }
        return initPage(driver, ProductDetailPageBase.class);
    }
}
