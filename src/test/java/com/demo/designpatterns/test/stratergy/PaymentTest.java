package com.demo.designpatterns.test.stratergy;

import com.demo.designpatterns.strategy.*;
import com.demo.designpatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PaymentTest extends BaseTest {
    private DeliveryPage deliveryPage;
    private PaymentPage paymentPage;

    @BeforeTest
    public void setupPage(){
        this.deliveryPage = new DeliveryPage(this.driver);
        this.paymentPage = new PaymentPage(this.driver);
    }
    @Test (dataProvider = "getPaymentData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) throws InterruptedException {
        this.deliveryPage.openDeliverySite();
        this.deliveryPage.chooseFastDeliveryMethod();
        Assert.assertTrue(this.paymentPage.getOrderComponent().isPaymentOptionsDisplayed());

        this.paymentPage.setPaymentOption(paymentOption);
        this.paymentPage.getPaymentOption().enterPaymentInformation(paymentDetails);
        this.paymentPage.getOrderComponent().doPayment();
        Assert.assertTrue(this.deliveryPage.isDeliveryPageDisplayed());
    }

    @DataProvider
    public Object[][] getPaymentData(){
        Map<String, String> creditCardData = new HashMap<>();
        creditCardData.put("cardName", "HO NGUYEN");
        creditCardData.put("cardNumber", "9988776655443322");
        creditCardData.put("expiryMonth", "2");
        creditCardData.put("expiryYear", "2090");

        Map<String, String> couponData = new HashMap<>();
        couponData.put("coupon", "9876543210");

        Map<String, String> merchandiseData = new HashMap<>();
        merchandiseData.put("merchandise", "StickerYou");

        return new Object[][]{
            { new PaymentOptionCreditCard(), creditCardData },
            { new PaymentOptionCoupon(), couponData },
            { new PaymentOptionOther(), merchandiseData }
        };
    }
}
