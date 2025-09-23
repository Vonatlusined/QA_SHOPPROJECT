package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void existLoginTest () {
        clickOnLoginLink();
        fillLoginForm();

        clickOnLoginButton();

        Assert.assertTrue(elementPresent(By.xpath("(//a[normalize-space()='Log out'])[1]")));

    }

    private void fillLoginForm() {
        type(By.xpath("(//input[@id='Email'])[1]"), "Joeblack@email.com");

        type(By.xpath("(//input[@id='Password'])[1]"), "Joeblack1234.");
    }

    public void clickOnLoginLink() {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
    }
}