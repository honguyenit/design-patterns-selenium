package com.demo.designpatterns.factory;

import org.openqa.selenium.WebDriver;

public class ResultPageFrench extends ResultPageEnglish{
    public ResultPageFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchResultsDisplayed() {
        return this.lblSearchResultTitle.getText().contains("Résultats de la recherche");
    }
}
