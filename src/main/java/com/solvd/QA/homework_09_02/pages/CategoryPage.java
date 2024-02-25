package com.solvd.QA.homework_09_02.pages;

import com.solvd.QA.homework_09_02.domain.Item;
import com.solvd.QA.homework_09_02.domain.ItemType;
import com.solvd.QA.homework_09_02.pages.components.ItemCard;
import com.solvd.QA.homework_09_02.pages.components.PromoItems;
import com.solvd.QA.homework_09_02.pages.components.SortSelect;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class CategoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='style_titleWrapper__zvAnV']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//*")
    private SortSelect selectSort;

    @FindBy(xpath = "//*")
    private PromoItems promoItems;

    @FindBy(xpath = "//div [@class='style_product__uOVkK']")
    private List<ItemCard> itemsCards;

    @FindBy(xpath = "//ul [@class='styles_list__PQC5Y']")
    private ExtendedWebElement bottomElement;

    @FindBy(xpath = "//span [@class='style_upButtonLabel__LPAA4']")
    private ExtendedWebElement upButton;

    @FindBy(xpath = "//div [@class='popmechanic-close']")
    private ExtendedWebElement popNotification;

    public CategoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(header);
    }

    public CategoryPage switchPageTo(ItemType itemType){
        return promoItems.getPageBy(itemType);
    }

    public List<Item> getItems() {
        List<Item> result = new LinkedList<>();
        for (int i=0; i<itemsCards.size(); i++) {
//            popNotification.clickIfPresent();
            result.add(itemsCards.get(i).getItem());
        }
        return result;
    }

    public CategoryPage sortItem(Sort sort){
        return selectSort.getSortedItemBy(sort);
    }

    public boolean isVisibleUpButton(){
        return upButton.isVisible();
    }

    public ExtendedWebElement getBottomElement() {
        return bottomElement;
    }
}
