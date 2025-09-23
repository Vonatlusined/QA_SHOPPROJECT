package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLoginForm(new User("Joeblack@email.com", "Joeblack1234."));
        clickOnLoginButton();
        driver.findElement(By.cssSelector("div[class='product-item'] a[title='Show details for 14.1-inch Laptop']")).click();
        clickOnAddCartButton();
    }
    @Test
    public void deleteCart (){
        deleteContact();
    }


    }

