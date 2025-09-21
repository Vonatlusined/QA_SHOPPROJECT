package com.onlineshop.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTest extends TestBase{
    @Test
    public void newUserRegistrationPositiveTest(){
        driver.findElement(By.cssSelector("[href='/register']")).click(); // клик на кнопку регистрации

        driver.findElement(By.cssSelector("[id=\"gender-male\"]")).click(); //выбор гендера

        driver.findElement(By.cssSelector("[id$='FirstName']")).click();
        driver.findElement(By.cssSelector("[id$='FirstName']")).clear();
        driver.findElement(By.cssSelector("[id$='FirstName']")).sendKeys("Joe"); //клик и заполнение поля имени

        driver.findElement(By.cssSelector("[id=\"LastName\"]")).click();
        driver.findElement(By.cssSelector("[id=\"LastName\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"LastName\"]")).sendKeys("Black"); //клик и заполнение поля Фамилии

        driver.findElement(By.cssSelector("[id=\"Email\"]")).click();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys("Joeblack@email.com"); //клик и заполнение поля Email


        driver.findElement(By.cssSelector("[id=\"Password\"]")).click();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("Joeblack1234."); //пароль

        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).click();
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).sendKeys("Joeblack1234."); //повтор пароля

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
    public void existUserRegistrationPositiveTest(){
        driver.findElement(By.cssSelector("[href='/register']")).click(); // клик на кнопку регистрации

        driver.findElement(By.cssSelector("[id=\"gender-male\"]")).click(); //выбор гендера

        driver.findElement(By.cssSelector("[id$='FirstName']")).click();
        driver.findElement(By.cssSelector("[id$='FirstName']")).clear();
        driver.findElement(By.cssSelector("[id$='FirstName']")).sendKeys("Joe"); //клик и заполнение поля имени

        driver.findElement(By.cssSelector("[id=\"LastName\"]")).click();
        driver.findElement(By.cssSelector("[id=\"LastName\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"LastName\"]")).sendKeys("Black"); //клик и заполнение поля Фамилии

        driver.findElement(By.cssSelector("[id=\"Email\"]")).click();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys("Joeblack@email.com"); //клик и заполнение поля Email


        driver.findElement(By.cssSelector("[id=\"Password\"]")).click();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("Joeblack1234."); //пароль

        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).click();
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).sendKeys("Joeblack1234."); //повтор пароля

        driver.findElement(By.cssSelector("[id=\"register-button\"]")).click();

        Assert.assertTrue(elementPresent(By.xpath("//li[normalize-space()='The specified email already exists']")));

    }
}
