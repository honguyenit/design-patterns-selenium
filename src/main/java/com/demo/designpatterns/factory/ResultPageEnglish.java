package com.demo.designpatterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPageEnglish extends ResultPage{
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(className = "mat-paginator-range-label")
    private WebElement lblPaginationInfo;

    @FindBy(css = "div.heading span:first-of-type")
    protected WebElement lblSearchResultTitle;

    @FindBy(id = "searchValue")
    private WebElement lblSearchValue;

    public ResultPageEnglish(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public boolean isSearchResultsDisplayed() {

        return this.lblSearchResultTitle.getText().contains("Search Results");
    }

    @Override
    public int getResultCount() {
        String pagingInfo = this.lblPaginationInfo.getText();
        return Integer.parseInt(pagingInfo.split("of")[1].trim());
    }

    @Override
    public boolean doesSearchResultsContainProductName(String productName) {
        return this.lblSearchValue.getText().equals(productName);
    }
}
