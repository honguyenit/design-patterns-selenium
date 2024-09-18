package com.demo.designpatterns.pomsrp.common;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftNavigation extends AbstractComponent {

    @FindBy (css = "button[aria-label='Open Sidenav']")
    private WebElement btnLeftNav;

    @FindBy (xpath = "//mat-sidenav")
    private WebElement panelLeftNav;

    @FindBy(xpath = "//span[contains(text(),'Customer Feedback')]")
    private WebElement lnkCustomerFeedback;

    @FindBy(xpath = "//span[contains(text(),'Complaint')]")
    private WebElement lnkComplaint;

    @FindBy(xpath = "//span[contains(text(),'Support Chat')]")
    private WebElement lnkSupportChat;

    @FindBy(xpath = "//span[contains(text(),'About Us')]")
    private WebElement lnkAboutUs;

    @FindBy(xpath = "//span[contains(text(),'Photo Wall')]")
    private WebElement lnkPhotoWall;

    @FindBy(xpath = "//span[contains(text(),'Deluxe Membership')]")
    private WebElement lnkDeluxeMembership;

    @FindBy(xpath = "//span[contains(text(),'Score Board')]")
    private WebElement lnkScoreBoard;

    @FindBy(xpath = "//span[contains(text(),'GitHub')]")
    private WebElement lnkGitHub;

    public LeftNavigation(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.lnkCustomerFeedback.isDisplayed()
        && this.lnkComplaint.isDisplayed()
        && this.lnkSupportChat.isDisplayed()
        && this.lnkAboutUs.isDisplayed());
    }

    public void openLeftNav(){
        this.btnLeftNav.click();
    }

    public void openLeftNavWhenItIsClosed(){
        WebElement panelLeftNavEl = null;
        try {
            panelLeftNavEl = this.wait.until(ExpectedConditions.visibilityOf(this.panelLeftNav));
        } catch (TimeoutException e) {
            System.out.println("panelLeftNavEl is not visible within the timeout.");
        }

        if (panelLeftNavEl == null) {
            this.btnLeftNav.click();  // Click the button if it's clickable
        }
    }

    public void openCustomerComplaintForm(){
        this.openLeftNavWhenItIsClosed();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.lnkComplaint));
        this.lnkComplaint.click();
    }

    public void openAboutUs(){
        this.openLeftNavWhenItIsClosed();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.lnkAboutUs));
        this.lnkAboutUs.click();
    }
}
