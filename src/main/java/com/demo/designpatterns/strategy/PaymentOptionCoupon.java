package com.demo.designpatterns.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PaymentOptionCoupon implements PaymentOption{
    @FindBy(xpath = "//*[text()=' Add a coupon ']")
    private WebElement btnAddCoupon;

    @FindBy(id = "coupon")
    private WebElement txtCoupon;

    @FindBy(id = "applyCouponButton")
    private WebElement btnRedeem;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) throws InterruptedException {
        this.btnAddCoupon.click();
        Thread.sleep(1000);
        this.txtCoupon.sendKeys(paymentDetails.get("coupon"));
        this.btnRedeem.click();
    }
}
