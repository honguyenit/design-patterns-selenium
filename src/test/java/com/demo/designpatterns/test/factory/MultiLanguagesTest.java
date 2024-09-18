package com.demo.designpatterns.test.factory;

import com.demo.designpatterns.factory.HomePage;
import com.demo.designpatterns.factory.PageFactoryProvider;
import com.demo.designpatterns.factory.ResultPage;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiLanguagesTest extends BaseTest {
    private HomePage homePage;
    private ResultPage resultPage;

    @Test (dataProvider = "getData")
    public void searchProductTest(String language, String searchKeyword){
        // init page with factory provider
        this.homePage = PageFactoryProvider.getHomePage(language, this.driver);
        this.resultPage = PageFactoryProvider.getResultPage(language, this.driver);

        // select language
        this.homePage.launchSite();
        this.homePage.selectLanguage(language);
        //search product
        this.homePage.searchProducts(searchKeyword);
        Assert.assertTrue(this.resultPage.doesSearchResultsContainProductName(searchKeyword));
        Assert.assertTrue(this.resultPage.isSearchResultsDisplayed());
        Assert.assertTrue(this.resultPage.getResultCount() > 0);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                {"EN", "Juice"},
                {"FR", "Jus de"},
                {"SP", "Manzana"}
        };
    }
}
