package com.solvd.QA.homework_09_02.pages;

import com.solvd.QA.homework_09_02.domain.Item;
import com.solvd.QA.homework_09_02.domain.ItemType;
import com.solvd.QA.homework_09_02.pages.components.PromoItems;
import com.solvd.QA.homework_09_02.pages.components.SortSelect;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CategoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='style_titleWrapper__zvAnV']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//*")
    private SortSelect selectSort;

    @FindBy(xpath = "//*")
    private PromoItems promoItems;

    @FindBy(xpath = "//div [@class='style_product__uOVkK']")
    private List<ExtendedWebElement> resultItem;

    @FindBy(xpath = "//ul [@class='styles_list__PQC5Y']")
    private ExtendedWebElement bottomElement;

    @FindBy(xpath = "//span [@class='style_upButtonLabel__LPAA4']")
    private ExtendedWebElement upButton;

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
        for (ExtendedWebElement element : resultItem) {
            String nameItem = null;
            String price = null;
            try{
                nameItem = element.findElement(By.xpath(".//a[@data-testid='card-info-a']")).getText();
                price = element.findElement(By.xpath(".//p [@data-testid='card-current-price']")).getText().replace("р.", "");

            }catch (NullPointerException | NoSuchElementException e){
                if(price==null){
                    price="00.00";
                }else{
                    continue;
                }
            }
            Item item = new Item(nameItem, price);
            result.add(item);
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
