package com.solvd.QA.lecture05_02.web;

import com.solvd.QA.lecture05_02.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Homepage extends AbstractPage {

    @FindBy(xpath = "//header")
    public Header header;

    public Homepage(WebDriver driver) {
        super(driver);
//        setPageAbsoluteURL(Configuration.getRequired("home_url")); /1 approach
//        setPageURL("/"); /2 approach
    }

    /**
     * 3 approach
     */
    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
