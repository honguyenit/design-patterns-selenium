package com.demo.designpatterns.pomsrp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductList extends AbstractComponent {

    @FindBy(className = "mat-grid-tile-content")
    private List<WebElement> products;

    public ProductList(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.products.size() > 1);
    }
}
