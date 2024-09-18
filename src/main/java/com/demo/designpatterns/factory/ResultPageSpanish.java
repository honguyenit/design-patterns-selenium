package com.demo.designpatterns.factory;

import org.openqa.selenium.WebDriver;

public class ResultPageSpanish extends ResultPageEnglish{
    public ResultPageSpanish(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchResultsDisplayed() {
        return this.lblSearchResultTitle.getText().contains("Buscar Resultados");
    }
}
