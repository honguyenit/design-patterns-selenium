package com.demo.designpatterns.template;

import com.demo.designpatterns.template.pages.SauceCartPage;
import com.demo.designpatterns.template.pages.SauceCheckoutPage;
import com.demo.designpatterns.template.pages.SauceHomePage;
import com.demo.designpatterns.template.pages.SauceLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceShop extends BaseShoppingTemplate {
    private WebDriver driver;
    private String product;

    private SauceLoginPage sauceLoginPage;
    private SauceHomePage sauceHomePage;
    private SauceCartPage sauceCartPage;
    private SauceCheckoutPage sauceCheckoutPage;

    public SauceShop(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.sauceLoginPage = PageFactory.initElements(driver, SauceLoginPage.class);
        this.sauceHomePage = PageFactory.initElements(driver, SauceHomePage.class);
        this.sauceCartPage = PageFactory.initElements(driver, SauceCartPage.class);
        this.sauceCheckoutPage = PageFactory.initElements(driver, SauceCheckoutPage.class);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.saucedemo.com");
    }

    @Override
    public void login() {
        this.sauceLoginPage.login("standard_user", "secret_sauce");
    }

    @Override
    public void addItemsToCart() {
        this.sauceHomePage.selectProduct(this.product);
    }

    @Override
    public void checkShoppingCart() {
        this.sauceHomePage.goToCart();
        Assert.assertTrue(
                this.sauceCartPage.checkShoppingCartContainingProduct(this.product));
        this.sauceCartPage.goCheckout();
    }

    @Override
    public void checkout() {
        this.sauceCheckoutPage.doCheckout();
    }

    @Override
    public void doPayment() {
        // do payment code here
    }
}
