package com.demo.designpatterns.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PaymentOptionOther implements PaymentOption {

    @FindBy(xpath = "//*[contains(text(),'Other payment options')]")
    private WebElement btnOtherOption;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        System.out.println("paymentDetails: " + paymentDetails.get("merchandise"));
        this.btnOtherOption.click();
    }
}
