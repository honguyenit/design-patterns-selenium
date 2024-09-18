package com.demo.designpatterns.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    private PaymentOption paymentOption;
    private OrderComponent orderComponent;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        this.orderComponent = PageFactory.initElements(driver, OrderComponent.class);
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(this.driver, this.paymentOption);
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public OrderComponent getOrderComponent() {
        return orderComponent;
    }
}
