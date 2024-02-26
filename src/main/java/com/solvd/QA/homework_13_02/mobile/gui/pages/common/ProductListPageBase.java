package com.solvd.QA.homework_13_02.mobile.gui.pages.common;

import com.solvd.QA.homework_13_02.mobile.gui.models.ProductDto;
import com.solvd.QA.homework_13_02.mobile.gui.models.Sort;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends AbstractPage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListPageBase sortProductBy(Sort typeSort);

    public abstract ProductListPageBase swapPage();

    public abstract List<ProductDto> getProducts(Integer count);

    public abstract ProductDto getRandomProduct(Integer count);

    public abstract ProductDetailPageBase goToDetailPageFullyShownProduct();
}
