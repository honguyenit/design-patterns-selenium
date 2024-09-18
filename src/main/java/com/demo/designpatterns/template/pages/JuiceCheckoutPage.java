package com.demo.designpatterns.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JuiceCheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".mat-table .mat-row:first-of-type")
    private WebElement option1Address;

    @FindBy(css = "button.btn-next")
    private WebElement btnSelectAddress;

    public JuiceCheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void doCheckout(){
        this.option1Address.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnSelectAddress));
        this.btnSelectAddress.click();
    }
}
