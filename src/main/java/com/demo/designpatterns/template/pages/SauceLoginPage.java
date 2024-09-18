package com.demo.designpatterns.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SauceLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user-name")
    private WebElement txtUsername;

    @FindBy (id = "password")
    private WebElement txtPassword;

    @FindBy (id = "login-button")
    private WebElement btnLogin;

    public SauceHomePage login(String userName, String password){
        this.txtUsername.sendKeys(userName);
        this.txtPassword.sendKeys(password);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnLogin));
        this.btnLogin.click();
        return new SauceHomePage(this.driver);
    }
}
