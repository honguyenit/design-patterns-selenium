package com.demo.designpatterns.pomsrp.leftnav;

import com.demo.designpatterns.pomsrp.common.LeftNavigation;
import com.demo.designpatterns.pomsrp.common.TopNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {
    private WebDriver driver;
    private LeftNavigation leftNavigation;
    private TopNavigation topNavigation;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[text()='About Us']")
    private WebElement headerAboutUs;


    public AboutUsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);

        this.leftNavigation = PageFactory.initElements(driver, LeftNavigation.class);
        this.topNavigation = PageFactory.initElements(driver, TopNavigation.class);
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public TopNavigation getTopNavigation() {
        return topNavigation;
    }

    public boolean isAboutUsFormDisplay(){
        return this.wait.until(d -> this.headerAboutUs.isDisplayed());
    }
}
