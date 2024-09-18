package com.demo.designpatterns.test.pomsrp;
import com.demo.designpatterns.pomsrp.main.HomePage;
import com.demo.designpatterns.pomsrp.LoginPage;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceShopLoginTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeTest
    public void setupPage(){
        this.loginPage = new LoginPage(this.driver);
        this.homePage = new HomePage(this.driver);
    }

    @Test
    public void loginTest(){
        this.loginPage.goToLoginPage();
        this.loginPage.login("qatest@gmail.com", "qatest");
        Assert.assertTrue(this.homePage.getProductList().isDisplayed());
    }
}
