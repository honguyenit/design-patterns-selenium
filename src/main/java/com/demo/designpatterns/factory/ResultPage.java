package com.demo.designpatterns.factory;

public abstract class ResultPage {
    public abstract boolean isSearchResultsDisplayed();
    public abstract int getResultCount();
    public abstract boolean doesSearchResultsContainProductName(String productName);
}
