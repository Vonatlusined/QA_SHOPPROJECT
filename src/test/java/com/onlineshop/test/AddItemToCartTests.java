package com.onlineshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        type(By.xpath("(//input[@id='Email'])[1]"), "Joeblack@email.com");
        type(By.xpath("(//input[@id='Password'])[1]"), "Joeblack1234.");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
    }

    @Test
    public void addToCartPositveTest() {
        driver.findElement(By.cssSelector("div[class='product-item'] a[title='Show details for 14.1-inch Laptop']")).click();
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button-31'])[1]")).click();
        Assert.assertTrue(isContactAdded("shopping cart"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacs = driver.findElements(By.cssSelector("p[class='content'] a"));
        for (WebElement element : contacs) {
            if (element.getText().contains(text))
                return true;
        }
        return false;


    }
    @AfterMethod
    public void postCondition(){
        driver.findElement(By.cssSelector("li[id='topcartlink'] a[class='ico-cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.cssSelector("input[value='Update shopping cart']")).click();


    }
}

