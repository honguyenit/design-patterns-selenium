package com.demo.designpatterns.test.template;

import com.demo.designpatterns.template.BaseShoppingTemplate;
import com.demo.designpatterns.template.JuiceShop;
import com.demo.designpatterns.template.SauceShop;
import com.demo.designpatterns.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingFlowTest extends BaseTest {

    @Test (dataProvider = "getShoppingData")
    public void shoppingFlowTest(BaseShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getShoppingData(){
        return new Object[]{
                new JuiceShop(this.driver, "Apple"),
                new SauceShop(this.driver, "Sauce Labs")
        };
    }
}
