package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void existLoginTest () {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        type(By.xpath("(//input[@id='Email'])[1]"), "Joeblack@email.com");

        type(By.xpath("(//input[@id='Password'])[1]"), "Joeblack1234.");

        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertTrue(elementPresent(By.xpath("(//a[normalize-space()='Log out'])[1]")));

    }
}
