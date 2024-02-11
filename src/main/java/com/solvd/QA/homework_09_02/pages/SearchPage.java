package com.solvd.QA.homework_09_02.pages;

import com.solvd.QA.homework_09_02.domain.Item;
import com.solvd.QA.homework_09_02.pages.components.ItemBlock;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='content__header cr-category_header']")
    private ExtendedWebElement resultSearchTitle;

    @FindBy(xpath = "//div[@class='b-result g-box_lseparator']")
    private List<ItemBlock> blockList;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(resultSearchTitle);
    }

    public List<Item> getAllItemFromPage() {
        List<Item> result = new LinkedList<>();
        for (ItemBlock block : blockList) {
            List<Item> items = block.getItems();
            result.addAll(items);
        }
        return result;
    }


}
