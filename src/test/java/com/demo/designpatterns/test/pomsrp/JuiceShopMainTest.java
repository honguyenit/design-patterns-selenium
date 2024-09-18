package com.demo.designpatterns.test.pomsrp;
import com.demo.designpatterns.pomsrp.leftnav.AboutUsPage;
import com.demo.designpatterns.pomsrp.leftnav.ComplaintPage;
import com.demo.designpatterns.pomsrp.main.HomePage;
import com.demo.designpatterns.pomsrp.LoginPage;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceShopMainTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ComplaintPage complaintPage;
    private AboutUsPage aboutUsPage;

    @BeforeTest
    public void setupPage(){
        this.loginPage = new LoginPage(this.driver);
        this.homePage = new HomePage(this.driver);
        this.complaintPage = new ComplaintPage(this.driver);
        this.aboutUsPage = new AboutUsPage(this.driver);

        this.loginPage.goToLoginPage();
        this.loginPage.login("qatest@gmail.com", "qatest");
    }

    @Test
    public void leftNavigationTest(){
        this.homePage.gotoHomePage();
        Assert.assertTrue(this.homePage.getProductList().isDisplayed());

        // left Navigation test
        this.homePage.getLeftNavigation().openLeftNav();
        Assert.assertTrue(this.homePage.getLeftNavigation().isDisplayed());
    }

    @Test
    public void customerComplaintTest(){
        this.homePage.gotoHomePage();
        Assert.assertTrue(this.homePage.getProductList().isDisplayed());

        // complain test
        this.homePage.getLeftNavigation().openCustomerComplaintForm();
        Assert.assertTrue(this.complaintPage.isComplaintFormDisplay());
        String complaintResult = this.complaintPage.doComplain("This is not acceptable");
        Assert.assertTrue(complaintResult.contains("Customer support will get in touch with you soon!"));

        this.complaintPage.getLeftNavigation().openAboutUs();
        Assert.assertTrue(this.aboutUsPage.isAboutUsFormDisplay());
    }
}
