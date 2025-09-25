package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getHome().homeComponentPresent()) {
            app.getHome().clickOnHomeLink();
        }
    }

    @Test
    public void homeComponentPresentTest() {
        app.getHome().clickOnHomeLink();
        System.out.println("Home Component" + app.getHome().homeComponentPresent());
        Assert.assertTrue(app.getHome().homeComponentPresent());
    }


}
