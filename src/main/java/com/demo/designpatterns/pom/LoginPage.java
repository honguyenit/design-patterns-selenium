package com.demo.designpatterns.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email")
    private WebElement txtEmail;

    @FindBy (id = "password")
    private WebElement txtPassword;

    @FindBy (id = "loginButton")
    private WebElement btnLogin;

    public HomePage login(String email, String password){
        this.txtEmail.sendKeys(email);
        this.txtPassword.sendKeys(password);
        this.wait.until(
                ExpectedConditions.elementToBeClickable(this.btnLogin));
        this.btnLogin.click();
        return new HomePage(this.driver);
    }
}
