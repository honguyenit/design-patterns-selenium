package sample;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JuiceSearchTest {
    WebDriver driver;
    WebDriverWait wait;

    // Locating elements in Login page
    @FindBy(css = "[aria-label='Close Welcome Banner']")
    WebElement btnDismiss;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "loginButton")
    WebElement btnLogin;

    // Locating elements in Home page
    @FindBy(css = ".heading .ng-star-inserted")
    WebElement headerProducts;

    @FindBy(css = ".mat-search_icon-search")
    private WebElement btnSearch;

    @FindBy(id = "mat-input-0")
    private WebElement txtSearch;

    @FindBy(id = "searchValue")
    private WebElement searchValue;

    // Initializing WebDriver and PageFactory
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost:3000/#/login");
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements in this class
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void searchProductsTest() throws InterruptedException {
        String loginEmail = "qatest@gmail.com";
        String password = "qatest";
        String searchKeyword = "Juice";

        // do login
        doLogin(loginEmail, password);
        Assert.assertTrue(checkHomePageHeader().contains("All Products"));

        // search products and verify search results
        searchProduct(searchKeyword);

        // verify search results
        Assert.assertTrue(searchValue.getText().contains(searchKeyword));
    }

    private void doLogin(String email, String password){
        btnDismiss.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    private String checkHomePageHeader(){
        this.wait.until(d -> this.headerProducts.isDisplayed());
        return headerProducts.getText();
    }

    private void searchProduct(String keyword){
        btnSearch.click();
        txtSearch.sendKeys(keyword + Keys.ENTER);
        wait.until(d -> searchValue.isDisplayed());
    }
}
