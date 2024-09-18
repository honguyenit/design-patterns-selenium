package com.demo.designpatterns.template;

public abstract class BaseShoppingTemplate {
    public abstract void launchSite();
    public abstract void login();
    public abstract void addItemsToCart();
    public abstract void checkShoppingCart();
    public abstract void checkout();
    public abstract void doPayment();

    public void shop() {
        launchSite();
        login();
        addItemsToCart();
        checkShoppingCart();
        checkout();
        doPayment();
    }
}
