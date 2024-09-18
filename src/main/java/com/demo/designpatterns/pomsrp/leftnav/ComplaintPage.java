package com.demo.designpatterns.pomsrp.leftnav;

import com.demo.designpatterns.pomsrp.common.LeftNavigation;
import com.demo.designpatterns.pomsrp.common.TopNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplaintPage {
    private WebDriver driver;
    private LeftNavigation leftNavigation;
    private TopNavigation topNavigation;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[text()='Complaint']")
    private WebElement headerCustomerComplaint;

    @FindBy(id = "complaintMessage")
    private WebElement txtComplaintMessage;

    @FindBy(id = "submitButton")
    private WebElement btnSubmit;

    @FindBy(className = "confirmation")
    private WebElement lblResult;


    public ComplaintPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);

        this.leftNavigation = PageFactory.initElements(driver, LeftNavigation.class);
        this.topNavigation = PageFactory.initElements(driver, TopNavigation.class);
    }

    public boolean isComplaintFormDisplay(){
        return this.wait.until(d -> this.headerCustomerComplaint.isDisplayed());
    }

    public String doComplain(String message){
        this.txtComplaintMessage.sendKeys(message);
        this.btnSubmit.click();
        this.wait.until(d -> this.lblResult.isDisplayed());
        return this.lblResult.getText();
    }

    public TopNavigation getTopNavigation() {
        return topNavigation;
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }
}
