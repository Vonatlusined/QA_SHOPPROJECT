package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        click(By.cssSelector("a[href='/']"));
        clickOnRegistrationLink(); // клик на кнопку регистрации

        fillRegisterLoginForm("Joeblack@email.com", "Joeblack1234.", "Joe", "Black");
        clickOnRegistrationButton();

        Assert.assertTrue(isSignOutButton());

        //Assert.assertTrue(isAssertDisplayed());

    }

    @Test
    public void existUserRegistrationNegativeTest(){
        clickOnRegistrationLink(); // клик на кнопку регистрации

        fillRegisterLoginForm("Joeblack@email.com", "Joeblack1234.", "Joe", "Black");

        clickOnRegistrationButton();

        Assert.assertTrue(elementPresent(By.xpath("//li[normalize-space()='The specified email already exists']")));

    }

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

