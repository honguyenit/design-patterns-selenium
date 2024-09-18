package com.demo.designpatterns.test.pom;

import com.demo.designpatterns.pom.HomePage;
import com.demo.designpatterns.pom.LoginPage;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceShopTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeTest
    public void setLoginPage(){
        this.homePage = new HomePage(this.driver);
    }

    @Test
    public void productsSearchTest(){
        String email = "qatest@gmail.com";
        String pass = "qatest";
        String keyword = "Juice";

        // launch site
        this.homePage.launchSite();
        this.homePage.dismissWelcomePopup();
        this.loginPage = this.homePage.goToLogin();

        // do login
        this.loginPage.login(email, pass);
        Assert.assertTrue(this.homePage.isProductListDisplayed());

        // search keyword
        this.homePage.searchProducts(keyword);
        Assert.assertTrue(this.homePage.doesSeachResultContainProducts(keyword));
    }
}


