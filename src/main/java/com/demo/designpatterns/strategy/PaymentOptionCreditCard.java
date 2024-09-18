package com.demo.designpatterns.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PaymentOptionCreditCard implements PaymentOption{

    @FindBy(xpath = "//*[contains(text(),'Add new card')]")
    private WebElement btnAddCard;

    @FindBy(xpath = "//*[text()='Name']/parent::*/parent::*/parent::*/input")
    private WebElement txtCardName;

    @FindBy(xpath = "//*[text()='Card Number']/parent::*/parent::*/parent::*/input")
    private WebElement txtCardNumber;

    @FindBy(xpath = "//*[text()='Expiry Month']/parent::*/parent::*/parent::*/select")
    private WebElement selectExpiryMonth;

    @FindBy(xpath = "//*[text()='Expiry Year']/parent::*/parent::*/parent::*/select")
    private WebElement selectExpiryYear;

    @FindBy(id = "submitButton")
    private WebElement btnSubmitCard;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) throws InterruptedException {
        this.btnAddCard.click();
        Thread.sleep(1000);
        this.txtCardName.sendKeys(paymentDetails.get("cardName"));
        this.txtCardNumber.sendKeys(paymentDetails.get("cardNumber"));

        Select monthSelect = new Select(this.selectExpiryMonth);
        Select yearSelect = new Select(this.selectExpiryYear);
        monthSelect.selectByValue(paymentDetails.get("expiryMonth"));
        yearSelect.selectByValue(paymentDetails.get("expiryYear"));

        this.btnSubmitCard.click();
    }
}
