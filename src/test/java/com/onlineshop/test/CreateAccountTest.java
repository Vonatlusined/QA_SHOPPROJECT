package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        click(By.cssSelector("a[href='/']"));
        driver.findElement(By.cssSelector("[href='/register']")).click(); // клик на кнопку регистрации

        driver.findElement(By.cssSelector("[id=\"gender-male\"]")).click(); //выбор гендера

        type(By.cssSelector("[id$='FirstName']"), "Joe");

        type(By.cssSelector("[id=\"LastName\"]"), "Black");

        type(By.cssSelector("[id=\"Email\"]"), "Joeblack"+i+"@email.com");


        type(By.cssSelector("[id=\"Password\"]"), "Joeblack1234.");

        type(By.cssSelector("[id=\"ConfirmPassword\"]"), "Joeblack1234.");

        driver.findElement(By.cssSelector("[id=\"register-button\"]")).click();

        Assert.assertTrue(elementPresent(By.xpath("//li[normalize-space()='The specified email already exists']")));

        //Assert.assertTrue(isAssertDisplayed());

    }

    //    public boolean isAssertDisplayed() {
//        Alert alert = new WebDriver(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.alertIsPresent());
//        if (alert == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }



    @Test
    public void existUserRegistrationNegativeTest(){
        driver.findElement(By.cssSelector("[href='/register']")).click(); // клик на кнопку регистрации

        driver.findElement(By.cssSelector("[id=\"gender-male\"]")).click(); //выбор гендера

        type(By.cssSelector("[id$='FirstName']"), "Joe");

        type(By.cssSelector("[id=\"LastName\"]"), "Black");

        type(By.cssSelector("[id=\"Email\"]"), "Joeblack@email.com");


        type(By.cssSelector("[id=\"Password\"]"), "Joeblack1234.");

        type(By.cssSelector("[id=\"ConfirmPassword\"]"), "Joeblack1234.");

        driver.findElement(By.cssSelector("[id=\"register-button\"]")).click();

        Assert.assertTrue(elementPresent(By.xpath("//li[normalize-space()='The specified email already exists']")));

    }
}
