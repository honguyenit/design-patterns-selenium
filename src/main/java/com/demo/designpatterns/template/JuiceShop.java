package com.demo.designpatterns.template;

import com.demo.designpatterns.template.pages.JuiceCartPage;
import com.demo.designpatterns.template.pages.JuiceCheckoutPage;
import com.demo.designpatterns.template.pages.JuiceHomePage;
import com.demo.designpatterns.template.pages.JuiceLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JuiceShop extends BaseShoppingTemplate {
    private WebDriver driver;
    private String product;

    private JuiceLoginPage juiceLoginPage;
    private JuiceHomePage juiceHomePage;
    private JuiceCartPage juiceCartPage;
    private JuiceCheckoutPage juiceCheckoutPage;

    public JuiceShop(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.juiceLoginPage = PageFactory.initElements(driver, JuiceLoginPage.class);
        this.juiceHomePage = PageFactory.initElements(driver, JuiceHomePage.class);
        this.juiceCartPage = PageFactory.initElements(driver, JuiceCartPage.class);
        this.juiceCheckoutPage = PageFactory.initElements(driver, JuiceCheckoutPage.class);
    }

    @Override
    public void launchSite() {
        this.driver.get("http://localhost:3000/#/");
        this.juiceHomePage.dismissWelcomePopup();
    }

    @Override
    public void login() {
        this.juiceLoginPage.goToLogin();
        this.juiceLoginPage.login("qatest@gmail.com", "qatest");
    }

    @Override
    public void addItemsToCart() {
        this.juiceHomePage.selectProduct(this.product);
    }

    @Override
    public void checkShoppingCart() {
        this.juiceHomePage.goToCart();
        Assert.assertTrue(
                this.juiceCartPage.checkShoppingCartContainingProduct(this.product));
        this.juiceCartPage.goCheckout();
    }

    @Override
    public void checkout() {
        this.juiceCheckoutPage.doCheckout();
    }

    @Override
    public void doPayment() {
        // do payment code here
    }
}
