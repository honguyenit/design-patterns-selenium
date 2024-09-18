package com.demo.designpatterns.strategy;

import java.util.Map;

public interface PaymentOption {
    void enterPaymentInformation(Map<String, String> paymentDetails) throws InterruptedException;
}
