package com.demo.designpatterns.pomsrp.result;

import com.demo.designpatterns.pomsrp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends AbstractComponent {

    @FindBy(id = "searchValue")
    private WebElement searchValue;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.searchValue.isDisplayed());
    }

    public boolean doesSeachResultContainProducts(String product){
        return this.searchValue.getText().contains(product);
    }
}
