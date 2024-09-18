package com.demo.designpatterns.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderComponent {
    private WebDriverWait wait;

    @FindBy (css = "button.btn-return")
    private WebElement btnOrder;

    @FindBy (xpath = "//h1[text()='My Payment Options']")
    private WebElement titlePaymentOptions;

    public OrderComponent(WebDriver driver){
        this.wait = new WebDriverWait(driver, 5);
    }

    public boolean isPaymentOptionsDisplayed(){
        return this.wait.until(d -> this.titlePaymentOptions.isDisplayed());
    }

    public void doPayment(){
        this.btnOrder.click();
    }
}
