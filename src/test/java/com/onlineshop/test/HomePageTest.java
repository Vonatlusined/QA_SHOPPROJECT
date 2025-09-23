package com.onlineshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void homeComponentPresentTest(){
        click(By.cssSelector("a[href='/']"));
        System.out.println("Home Component"+ homeComponentPresent());
        Assert.assertTrue(homeComponentPresent());
    }


}
