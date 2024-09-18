package com.demo.designpatterns.factory;

public abstract class HomePage {
    public abstract void launchSite();
    public abstract void selectLanguage(String language);
    public abstract void searchProducts(String keyword);
}
