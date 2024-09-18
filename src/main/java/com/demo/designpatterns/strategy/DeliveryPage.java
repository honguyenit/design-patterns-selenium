package com.demo.designpatterns.strategy;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement btnDismiss;

    @FindBy(xpath = "//h1[text()='Choose a delivery speed']")
    private WebElement titleDeliverySpeed;

    @FindBy(xpath = "//*[contains(text(),'Fast Delivery')]")
    private WebElement optionFastDelivery;

    @FindBy(css = "button.nextButton")
    private WebElement btnGoPayment;

    public DeliveryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void chooseFastDeliveryMethod(){
        this.optionFastDelivery.click();
        this.btnGoPayment.click();
    }

    public void openDeliverySite(){
        this.driver.get("http://localhost:3000/#/delivery-method");
        this.dismissWelcomePopup();
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

    public boolean isDeliveryPageDisplayed(){
        return this.isElementVisible(this.titleDeliverySpeed);
    }

    public void dismissWelcomePopup(){
        if(isElementVisible(this.btnDismiss)){
            this.btnDismiss.click();
        }
    }

}
