package com.demo.designpatterns.pomsrp.main;
import com.demo.designpatterns.pomsrp.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    private WelcomePopup welcomePopup;
    private LeftNavigation leftNavigation;
    private TopNavigation topNavigation;
    private ProductList productList;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.welcomePopup = PageFactory.initElements(driver, WelcomePopup.class);
        this.leftNavigation = PageFactory.initElements(driver, LeftNavigation.class);
        this.topNavigation = PageFactory.initElements(driver, TopNavigation.class);
        this.productList = PageFactory.initElements(driver, ProductList.class);
    }

    public void gotoHomePage(){
        this.driver.get("http://localhost:3000/#/");
        this.driver.navigate().refresh();
        if(this.welcomePopup.isDisplayed()){
            this.welcomePopup.dismissWelcomePopup();
        }
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public TopNavigation getTopNavigation() {
        return topNavigation;
    }

    public ProductList getProductList() {
        return productList;
    }
}
