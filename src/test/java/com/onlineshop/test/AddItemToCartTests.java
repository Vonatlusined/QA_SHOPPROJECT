package com.onlineshop.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm(new User("Joeblack@email.com", "Joeblack1234."));
        clickOnLoginButton();
    }
    @Test
    public void addToCartPositveTest() {
        fillCartAdd();
        Assert.assertTrue(isContactAdded("shopping cart"));
    }

    @AfterMethod
    public void postCondition(){
        deleteContact();
    }

}

