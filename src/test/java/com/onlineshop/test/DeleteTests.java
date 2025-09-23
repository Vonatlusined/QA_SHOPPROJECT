package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        type(By.xpath("(//input[@id='Email'])[1]"), "Joeblack@email.com");
        type(By.xpath("(//input[@id='Password'])[1]"), "Joeblack1234.");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        driver.findElement(By.cssSelector("div[class='product-item'] a[title='Show details for 14.1-inch Laptop']")).click();
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button-31'])[1]")).click();
    }
    @Test
    public void deleteCart (){
        driver.findElement(By.cssSelector("li[id='topcartlink'] a[class='ico-cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.cssSelector("input[value='Update shopping cart']")).click();
    }


    }

