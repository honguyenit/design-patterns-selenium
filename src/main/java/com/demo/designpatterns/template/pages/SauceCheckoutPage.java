package com.demo.designpatterns.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceCheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (className = "title")
    private WebElement headerCheckout;

    @FindBy(id  = "first-name")
    private WebElement txtCheckoutFirstName;

    @FindBy(id = "last-name")
    private WebElement txtCheckoutLastName;

    @FindBy(id = "postal-code")
    private WebElement txtCheckoutZipCode;

    @FindBy(id = "continue")
    private WebElement btnCheckout;

    public SauceCheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void doCheckout(){
        this.wait.until(d -> this.headerCheckout.isDisplayed());
        this.txtCheckoutFirstName.sendKeys("John");
        this.txtCheckoutLastName.sendKeys("Smith");
        this.txtCheckoutZipCode.sendKeys("70000");
        this.btnCheckout.click();
    }
}
