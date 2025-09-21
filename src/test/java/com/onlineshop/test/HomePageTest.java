package com.onlineshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void homeComponentPresentTest(){
       // driver.findElement(By.cssSelector("a[href='/']"));
        // System.out.println("Home Component"+ homeComponentPresent());
        Assert.assertTrue(homeComponentPresent());
    }


}
