package com.demo.designpatterns.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SauceHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(id = "shopping_cart_container")
    private WebElement btnBasket;

    public SauceHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void goToCart(){
        this.btnBasket.click();
    }

    public void selectProduct(String product) {
        this.wait.until(d -> this.products.size() > 3); // wait for the product list loaded

        for(WebElement item: this.products){
            String itemName = item.findElement(new By.ByClassName("inventory_item_name")).getText();
            WebElement btnAddToCartEl = item.findElement(new By.ByTagName("button"));

            if(itemName.toLowerCase().contains(product.toLowerCase())){
                btnAddToCartEl.click();
            }
        }
    }
}
