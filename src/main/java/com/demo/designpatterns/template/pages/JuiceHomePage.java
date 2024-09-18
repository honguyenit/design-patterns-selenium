package com.demo.designpatterns.template.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class JuiceHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (css = "[aria-label='Close Welcome Banner']")
    private WebElement btnDismiss;

    @FindBy (css = ".cc-dismiss")
    private WebElement btnCookie;

    @FindBy(className = "mat-grid-tile-content")
    private List<WebElement> products;

    @FindBy (css = "button[aria-label='Show the shopping cart']")
    private WebElement btnBasket;

    public JuiceHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String product) {
        this.wait.until(d -> this.products.size() > 10); // wait for the product list loaded

        for(WebElement item: this.products){
            String itemName = item.findElement(new By.ByClassName("item-name")).getText();
            WebElement btnAddToCartEl = item.findElement(new By.ByTagName("button"));

            if(itemName.toLowerCase().contains(product.toLowerCase())){
                JavascriptExecutor js = (JavascriptExecutor) this.driver;
                js.executeScript("arguments[0].scrollIntoView(true);", item); // scroll to the element
                this.wait.until(d -> item.isDisplayed());

                btnAddToCartEl.click();
            }
        }
    }

    public void goToCart(){
        this.btnBasket.click();
    }

    public void dismissWelcomePopup(){
        if(this.isElementVisible(this.btnDismiss)){
            this.btnDismiss.click();
        }

        if(this.isElementVisible(this.btnCookie)){
            this.btnCookie.click();
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            WebElement visibleElement = this.wait.until(ExpectedConditions.visibilityOf(element));
            return visibleElement != null;
        } catch (TimeoutException ex) {
            System.out.println(element + " is not visible within the timeout.");
            return false;
        }
    }
}
