package com.demo.designpatterns.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JuiceCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (css = "app-purchase-basket h1")
    private WebElement headerBasket;

    @FindBy (css = ".mat-table mat-row")
    private List<WebElement> items;

    @FindBy (id = "checkoutButton")
    private WebElement btnGoCheckOut;

    public JuiceCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public boolean checkShoppingCartContainingProduct(String product){
        this.wait.until(d -> this.headerBasket.isDisplayed());
        for(WebElement item: this.items){
            String itemName = item.findElement(new By.ByClassName("mat-column-product")).getText();
            if(!itemName.contains(product)){
                return false;
            }
        }
        return true;
    }

    public void goCheckout(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnGoCheckOut));
        this.btnGoCheckOut.click();

    }
}
