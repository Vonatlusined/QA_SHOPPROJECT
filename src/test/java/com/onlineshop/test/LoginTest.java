package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void LoginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User("Joeblack@email.com", "Joeblack1234."));
        clickOnLoginButton();
        Assert.assertTrue(elementPresent(By.xpath("(//a[normalize-space()='Log out'])[1]")));
    }
    @Test
    public void LoginNegativeTest() {
        clickOnLoginLink();
        fillLoginForm(new User("Joeblack@email.com", "Joeblack1234."));
        clickOnLoginButton();
        Assert.assertTrue(elementPresent(By.xpath("(//a[normalize-space()='Log out'])[1]")));
    }
}