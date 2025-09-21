package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void existLoginTest () {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        driver.findElement(By.xpath("(//input[@id='Email'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='Email'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@id='Email'])[1]")).sendKeys("Joeblack@email.com");

        driver.findElement(By.xpath("(//input[@id='Password'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='Password'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@id='Password'])[1]")).sendKeys("Joeblack1234.");

        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertTrue(elementPresent(By.xpath("(//a[normalize-space()='Log out'])[1]")));

    }
}
