package com.demo.designpatterns.pom;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (css = "[aria-label='Close Welcome Banner']")
    private WebElement btnDismiss;

    @FindBy (id = "navbarAccount")
    private WebElement btnAccount;

    @FindBy(id = "navbarLoginButton")
    private WebElement btnGoLogin;

    @FindBy (className = "mat-grid-tile-content")
    private List<WebElement> products;

    @FindBy(css = ".heading .ng-star-inserted")
    WebElement headerProducts;

    @FindBy(css = ".mat-search_icon-search")
    private WebElement btnSearch;

    @FindBy(id = "mat-input-0")
    private WebElement txtSearch;

    @FindBy(id = "searchValue")
    private WebElement searchValue;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    public void dismissWelcomePopup(){
        try {
            WebElement btnDismissEl = this.wait.until(ExpectedConditions.elementToBeClickable(this.btnDismiss));
            if (btnDismissEl != null) {
                btnDismissEl.click();  // Click the button if it's clickable
            }
        } catch (TimeoutException e) {
            System.out.println("The button 'btnDismiss' was not clickable within the timeout.");
        }
    }
    public void launchSite(){
        this.driver.get("http://localhost:3000/#/");
    }
    public LoginPage goToLogin(){
        this.btnAccount.click();
        this.wait.until(d -> this.btnGoLogin.isDisplayed());
        this.btnGoLogin.click();
        return new LoginPage(this.driver);
    }
    public boolean isProductListDisplayed(){
        return this.wait.until(d -> this.products.size() > 1);
    }
    public void searchProducts(String product){
        this.btnSearch.click();
        this.txtSearch.sendKeys(product + Keys.ENTER);
    }
    public boolean doesSeachResultContainProducts(String product){
        this.wait.until(d -> this.searchValue.isDisplayed());
        return this.searchValue.getText().contains(product);
    }
}
