package com.demo.designpatterns.pomsrp.common;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePopup extends AbstractComponent{
    public WelcomePopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement btnDismiss;

    @Override
    public boolean isDisplayed() {
       try {
            this.wait.until(ExpectedConditions.visibilityOf(this.btnDismiss));
            return this.btnDismiss.isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }

    public void dismissWelcomePopup(){
        WebElement btnDismissEl = this.wait.until(ExpectedConditions.elementToBeClickable(this.btnDismiss));
        btnDismissEl.click();
    }
}
