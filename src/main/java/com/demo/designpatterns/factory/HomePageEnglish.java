package com.demo.designpatterns.factory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageEnglish extends HomePage {

    // <editor-fold desc="Elements">
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement btnDismiss;

    @FindBy (css = "button[aria-label='Language selection menu']")
    private WebElement btnLanguage;

    @FindBy (xpath = "//mat-radio-button//div")
    private List<WebElement> languageOptions;

    @FindBy(css = ".mat-search_icon-search")
    private WebElement btnSearch;

    @FindBy(id = "mat-input-0")
    private WebElement txtSearch;

    public HomePageEnglish(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public void dismissWelcomePopup(){
        if(isElementVisible(this.btnDismiss)){
            this.btnDismiss.click();
        }
    }

    // </editor-fold>
    @Override
    public void launchSite() {
        this.driver.get("http://localhost:3000/#/search");
        this.driver.navigate().refresh();
        dismissWelcomePopup();
    }

    @Override
    public void selectLanguage(String languageCode) {
        Language language = Language.fromCode(languageCode);
        this.btnLanguage.click();
        for (WebElement o : languageOptions) {
            if (o.getText().toLowerCase().contains(
                    language.getLanguageName().toLowerCase())) {
                this.wait.until(d -> o.isDisplayed());
                o.click();
                break;
            }
        }
        this.driver.navigate().refresh();
    }


    @Override
    public void searchProducts(String keyword) {
        if(isElementVisible(this.btnSearch)){
            this.btnSearch.click();
        }

        this.wait.until(d -> this.txtSearch.isDisplayed());
        this.txtSearch.sendKeys(keyword + Keys.ENTER);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            WebElement visibleElement = this.wait.until(ExpectedConditions.visibilityOf(element));
            return visibleElement != null;
        } catch (TimeoutException ex) {
            System.out.println(element + " is not visible within the timeout.");
            return false;
        }
    }
}
