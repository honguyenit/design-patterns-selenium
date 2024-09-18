package com.demo.designpatterns.pomsrp.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigation extends AbstractComponent{

    @FindBy(css = ".mat-search_icon-search")
    private WebElement btnSearch;

    @FindBy(id = "mat-input-0")
    private WebElement txtSearch;

    @FindBy (id = "navbarAccount")
    private WebElement btnAccount;

    @FindBy (css = "button[aria-label='Show the shopping cart']")
    private WebElement btnBasket;

    @FindBy (css = "button[aria-label='Language selection menu']")
    private WebElement btnLanguage;


    public TopNavigation(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.btnSearch.isDisplayed());
    }

    public void searchProducts(String product){
        this.btnSearch.click();
        this.txtSearch.sendKeys(product + Keys.ENTER);
    }
}
