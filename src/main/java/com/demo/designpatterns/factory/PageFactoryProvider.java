package com.demo.designpatterns.factory;

import org.openqa.selenium.WebDriver;

public class PageFactoryProvider {

    public static HomePage getHomePage(String languageCode, WebDriver driver) {
        Language language = Language.fromCode(languageCode);
        switch (language) {
            case EN:
                return new HomePageEnglish(driver);
            case FR:
                return new HomePageFrench(driver);
            case SP:
                return new HomePageSpanish(driver);
            default:
                throw new IllegalArgumentException(languageCode + " is not supported.");
        }
    }

    public static ResultPage getResultPage(String languageCode, WebDriver driver) {
        Language language = Language.fromCode(languageCode);
        switch (language) {
            case EN:
                return new ResultPageEnglish(driver);
            case FR:
                return new ResultPageFrench(driver);
            case SP:
                return new ResultPageSpanish(driver);
            default:
                throw new IllegalArgumentException(languageCode + " is not supported.");
        }
    }
}