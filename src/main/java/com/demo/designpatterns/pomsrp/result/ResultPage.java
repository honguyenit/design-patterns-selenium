package com.demo.designpatterns.pomsrp.result;

import com.demo.designpatterns.pomsrp.common.LeftNavigation;
import com.demo.designpatterns.pomsrp.common.ProductList;
import com.demo.designpatterns.pomsrp.common.TopNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    private WebDriver driver;

    private LeftNavigation leftNavigation;
    private TopNavigation topNavigation;
    private ProductList productList;
    private SearchResults searchResults;
    private PaginationControls paginationControls;


    public ResultPage(WebDriver driver){
        this.driver = driver;
        this.leftNavigation = PageFactory.initElements(driver, LeftNavigation.class);
        this.topNavigation = PageFactory.initElements(driver, TopNavigation.class);
        this.searchResults = PageFactory.initElements(driver, SearchResults.class);
        this.productList = PageFactory.initElements(driver, ProductList.class);
        this.paginationControls = PageFactory.initElements(driver, PaginationControls.class);
    }

    public TopNavigation getTopNavigation() {
        return topNavigation;
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public ProductList getProductList() {
        return productList;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public PaginationControls getPaginationControls() {
        return paginationControls;
    }
}
