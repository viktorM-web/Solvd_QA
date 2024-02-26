package com.solvd.QA.homework_09_02.pages.components;

import com.solvd.QA.homework_09_02.pages.CategoryPage;
import com.solvd.QA.homework_09_02.pages.Sort;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SortSelect extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='styles_selectWrapper__MOQC2 styles_selectWrapper__uC_DR']")
    private ExtendedWebElement selectSort;

    @FindBy(xpath = ".//li[contains(@class, 'styles_selectOption__pOSTx styles_withCheckMark__DveqW styles_selectOption__aV4_k')]")
    private List<ExtendedWebElement> sortOption;

    public SortSelect(WebDriver driver) {
        super(driver);
    }

    public SortSelect(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CategoryPage getSortedItemBy(Sort sort) {
        selectSort.click();
        sortOption.stream().filter(option -> {
            String text = option.getText();
            return text.equals(sort.getName());
        })
                .findFirst().get().click();
        return new CategoryPage(driver);

    }
}
