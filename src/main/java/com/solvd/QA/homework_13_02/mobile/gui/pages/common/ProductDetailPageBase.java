package com.solvd.QA.homework_13_02.mobile.gui.pages.common;

import com.solvd.QA.homework_13_02.mobile.gui.models.ProductDto;
import com.solvd.QA.homework_13_02.mobile.gui.pages.android.ProductDetailPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends AbstractPage {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductDto getProductDto();

    public abstract ProductListPageBase back();

    public abstract ProductDetailPage closeUnnecessaryWindows();
}
