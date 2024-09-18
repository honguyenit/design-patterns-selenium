package com.demo.designpatterns.pomsrp.result;

import com.demo.designpatterns.pomsrp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginationControls extends AbstractComponent {

    @FindBy(className = "mat-paginator-range-label")
    private WebElement paginationInfoLabel;

    public PaginationControls(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.paginationInfoLabel.isDisplayed());
    }
}
