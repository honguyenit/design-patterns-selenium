package com.demo.designpatterns.test.pomsrp;

import com.demo.designpatterns.pomsrp.LoginPage;
import com.demo.designpatterns.pomsrp.main.HomePage;
import com.demo.designpatterns.pomsrp.result.ResultPage;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceShopProductTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ResultPage resultPage;

    @BeforeTest
    public void setupPage(){
        this.loginPage = new LoginPage(this.driver);
        this.homePage = new HomePage(this.driver);
        this.resultPage = new ResultPage(this.driver);
        this.loginPage.goToLoginPage();
        this.loginPage.login("qatest@gmail.com", "qatest");
    }

    @Test
    public void searchProductTest(){
        String searchProduct = "Juice";

        this.homePage.gotoHomePage();
        Assert.assertTrue(this.homePage.getProductList().isDisplayed());

        // search
        this.homePage.getTopNavigation().searchProducts(searchProduct);
        Assert.assertTrue(this.resultPage.getSearchResults().isDisplayed());
        Assert.assertTrue(this.resultPage.getPaginationControls().isDisplayed());
        Assert.assertTrue(this.resultPage.getSearchResults().doesSeachResultContainProducts(searchProduct));
    }

    @Test
    public void leftNavigationTest(){
        this.homePage.gotoHomePage();
        Assert.assertTrue(this.homePage.getProductList().isDisplayed());

        this.homePage.getLeftNavigation().openLeftNav();
        Assert.assertTrue(this.homePage.getLeftNavigation().isDisplayed());
    }

}
