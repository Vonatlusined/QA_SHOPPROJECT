package com.onlineshop.test;

import com.shop.data.UserData;
import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addToCartPositiveTest() {
        app.getCart().fillCartAdd();
        Assert.assertTrue(app.getCart().isContactAdded(getShoppingCart()));
    }

    @AfterMethod
    public void postCondition() {
        app.getCart().deleteCart();
    }

}

